package utils;

import java.io.IOException;
import java.io.Writer;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.LongAdder;

/** Uma medição por consulta. A gravação do log fica fora do tempo total. */
public class SearchMetrics {
    private final Properties values = new Properties();
    private final String module;
    private final Path logsDirectory;
    private final String timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSSSSSSSS"));
    private final long heapBefore = heapUsed();
    private final long gcCountBefore = gcCount();
    private final long gcTimeBefore = gcTime();
    private final long cpuBefore = processCpuTime();
    private final long started;
    private final LongAdder sortWorkerNs = new LongAdder();
    private final LongAdder searchWorkerNs = new LongAdder();

    public SearchMetrics(String module, String dataset, String query, String algorithm,
            String resultPolicy) {
        this.module = module;
        Path datasetPath = Path.of(dataset).toAbsolutePath().normalize();
        // Os datasets ficam em <raiz>/<modulo>/datasets/<p|g>.
        Path root = datasetPath;
        while (root != null && !Files.isDirectory(root.resolve(module).resolve("src"))) {
            root = root.getParent();
        }
        logsDirectory = (root == null ? Path.of("").toAbsolutePath() : root).resolve("logs");
        put("module", module);
        put("timestamp_local", LocalDateTime.now());
        put("dataset", datasetPath);
        put("query", query);
        put("algorithm", algorithm);
        put("result_policy", resultPolicy);
        put("comparison", "name.trim().equals(query); case-sensitive");
        put("java_version", System.getProperty("java.version"));
        put("java_vm", System.getProperty("java.vm.name"));
        put("os", System.getProperty("os.name"));
        put("os_arch", System.getProperty("os.arch"));
        put("available_processors", Runtime.getRuntime().availableProcessors());
        put("heap_max_bytes", Runtime.getRuntime().maxMemory());
        put("jvm_uptime_start_ms", ManagementFactory.getRuntimeMXBean().getUptime());
        started = System.nanoTime();
    }

    public void put(String key, Object value) {
        values.setProperty(key, String.valueOf(value));
    }

    public void file(int index, Path path, int lines, long bytes, long readNs) {
        String prefix = "file." + index + ".";
        put(prefix + "path", path.toAbsolutePath().normalize());
        put(prefix + "lines", lines);
        put(prefix + "bytes", bytes);
        put(prefix + "read_ns", readNs);
    }

    public void workerTimes(long sortNs, long searchNs) {
        sortWorkerNs.add(sortNs);
        searchWorkerNs.add(searchNs);
    }

    public void finish(List<Line> results, Throwable failure) {
        long elapsed = System.nanoTime() - started;
        put("total_ns", elapsed);
        put("status", failure == null ? "success" : "error");
        if (failure != null) {
            put("error_type", failure.getClass().getName());
            put("error_message", failure.getMessage());
        }
        put("result_count", results == null ? 0 : results.size());
        if (results != null) {
            for (int i = 0; i < results.size(); i++) {
                Line line = results.get(i);
                put("result." + i + ".file", line.file());
                put("result." + i + ".line", line.line());
                put("result." + i + ".name", line.name());
            }
        }
        put("sort_workers_sum_ns", sortWorkerNs.sum());
        put("search_workers_sum_ns", searchWorkerNs.sum());
        long heapAfter = heapUsed();
        put("heap_before_bytes", heapBefore);
        put("heap_after_bytes", heapAfter);
        put("heap_delta_bytes", heapAfter - heapBefore);
        put("gc_count_delta", gcCount() - gcCountBefore);
        put("gc_time_delta_ms", gcTime() - gcTimeBefore);
        long cpuAfter = processCpuTime();
        put("process_cpu_ns", cpuBefore < 0 || cpuAfter < 0 ? -1 : cpuAfter - cpuBefore);
        put("scope_note", "Wall times include instrumentation, exclude log writing and UI. "
                + "CPU/heap/GC are JVM-wide, not isolated to this query. Worker sums are not wall time.");
        try {
            Files.createDirectories(logsDirectory);
            Path log = logsDirectory.resolve(timestamp + "-" + module + ".properties");
            try (Writer writer = Files.newBufferedWriter(log, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
                values.store(writer, "Search metrics; durations in ns unless otherwise specified");
            }
        } catch (IOException e) {
            // Uma falha de logging não deve alterar o resultado da busca.
            System.err.println("Não foi possível salvar o log: " + e.getMessage());
        }
    }

    private static long heapUsed() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static long gcCount() {
        return ManagementFactory.getGarbageCollectorMXBeans().stream()
                .mapToLong(GarbageCollectorMXBean::getCollectionCount).filter(n -> n >= 0).sum();
    }

    private static long gcTime() {
        return ManagementFactory.getGarbageCollectorMXBeans().stream()
                .mapToLong(GarbageCollectorMXBean::getCollectionTime).filter(n -> n >= 0).sum();
    }

    private static long processCpuTime() {
        var bean = ManagementFactory.getOperatingSystemMXBean();
        return bean instanceof com.sun.management.OperatingSystemMXBean os
                ? os.getProcessCpuTime() : -1;
    }
}
