#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
repo="$PWD"
tmp=$(mktemp -d)
trap 'rm -rf "$tmp"' EXIT

cat > "$tmp/MetricsTest.java" <<'JAVA'
import utils.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MetricsTest {
    public static void main(String[] args) throws Exception {
        String module = args[0];
        Path root = Path.of(args[1]);
        Path data = root.resolve(module).resolve("datasets/p");
        Files.createDirectories(data);
        Files.createDirectories(root.resolve(module).resolve("src"));
        Files.writeString(data.resolve("a.txt"), "Zoe\n Ana \nAna\nana\n");
        Files.writeString(data.resolve("b.txt"), "Ana\nBob\n");
        Files.writeString(data.resolve("empty.txt"), "");
        var result = SearchUtils.Search(data.toString(), "Ana");
        int expected = module.equals("sem_paralelismo") ? 1 : 2;
        if (result.size() != expected) throw new AssertionError("Resultado: " + result);
        for (var line : result) {
            if (!line.name().trim().equals("Ana")) throw new AssertionError(line);
            if (line.file().equals("a.txt") && line.line() != 2) throw new AssertionError(line);
        }
        if (module.equals("sem_paralelismo_binary_search")
                && result.stream().noneMatch(line -> line.file().equals("b.txt") && line.line() == 1))
            throw new AssertionError("Faltou a primeira ocorrência de b.txt: " + result);
        if (!SearchUtils.Search(data.toString(), "Ausente").isEmpty())
            throw new AssertionError("Consulta ausente");
        try {
            SearchUtils.Search(data.resolve("inexistente").toString(), "Ana");
            throw new AssertionError("Deveria falhar");
        } catch (RuntimeException | java.io.IOException expectedError) {
            // A consulta inválida também deve gerar log.
        }
        int success = 0;
        int errors = 0;
        try (var logs = Files.list(root.resolve("logs"))) {
            for (Path log : logs.toList()) {
                if (!log.getFileName().toString().endsWith("-" + module + ".properties"))
                    throw new AssertionError(log);
                Properties p = new Properties();
                try (var reader = Files.newBufferedReader(log, StandardCharsets.UTF_8)) {
                    p.load(reader);
                }
                if (!p.getProperty("module").equals(module)) throw new AssertionError(p);
                if (Long.parseLong(p.getProperty("total_ns")) <= 0) throw new AssertionError(p);
                if (p.getProperty("status").equals("error")) {
                    errors++;
                    continue;
                }
                success++;
                if (!p.getProperty("loaded_lines").equals("6")) throw new AssertionError(p);
                if (!p.getProperty("file_count").equals("3")) throw new AssertionError(p);
                int count = p.getProperty("query").equals("Ana") ? expected : 0;
                if (Integer.parseInt(p.getProperty("result_count")) != count) throw new AssertionError(p);
                if (module.equals("sem_paralelismo_binary_search")) {
                    if (!p.getProperty("worker_threads").equals("0")
                            || !p.getProperty("algorithm").equals("sequential_binary_with_merge_sort")
                            || !p.getProperty("result_policy").equals("first_match_per_file")
                            || Long.parseLong(p.getProperty("sort_main_thread_ns")) <= 0
                            || Long.parseLong(p.getProperty("search_main_thread_ns")) <= 0
                            || !p.getProperty("sort_workers_sum_ns").equals("0"))
                        throw new AssertionError(p);
                } else if (module.equals("com_paralelismo_binary_search")
                        && Long.parseLong(p.getProperty("sort_workers_sum_ns")) <= 0)
                    throw new AssertionError(p);
                for (String key : List.of("read_wall_ns", "processing_wall_ns", "heap_after_bytes",
                        "process_cpu_ns", "gc_count_delta", "dataset_bytes")) {
                    Long.parseLong(p.getProperty(key));
                }
            }
        }
        if (success != 2 || errors != 1) throw new AssertionError(success + "/" + errors);
        System.out.println(module + ": OK");
    }
}
JAVA

for module in sem_paralelismo com_paralelismo com_paralelismo_binary_search sem_paralelismo_binary_search; do
    mkdir -p "$tmp/$module/classes" "$tmp/$module/fixture"
    javac -d "$tmp/$module/classes" $(find "$repo/$module/src" -name '*.java') "$tmp/MetricsTest.java"
    java -cp "$tmp/$module/classes" MetricsTest "$module" "$tmp/$module/fixture"
done
