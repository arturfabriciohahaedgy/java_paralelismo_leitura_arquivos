package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SearchUtils {
    public static List<Line> Search(String path, String query) throws IOException {
        SearchMetrics metrics = new SearchMetrics("sem_paralelismo_binary_search", path, query,
                "sequential_binary_with_merge_sort", "first_match_per_file");
        List<Line> result = null;
        Throwable failure = null;
        try {
            long readStart = System.nanoTime();
            List<Path> paths = FileUtils.listFiles(path);
            metrics.put("file_count", paths.size());
            metrics.put("worker_threads", 0);
            metrics.put("sorting_enabled", true);
            List<List<Line>> files = new ArrayList<>();
            long bytes = 0;
            long lines = 0;
            for (int i = 0; i < paths.size(); i++) {
                Path file = paths.get(i);
                long fileStart = System.nanoTime();
                List<Line> loaded = FileUtils.readAllLines(file);
                long readNs = System.nanoTime() - fileStart;
                long size = Files.size(file);
                metrics.file(i, file, loaded.size(), size, readNs);
                bytes += size;
                lines += loaded.size();
                files.add(loaded);
            }
            metrics.put("read_wall_ns", System.nanoTime() - readStart);
            metrics.put("dataset_bytes", bytes);
            metrics.put("loaded_lines", lines);

            long processingStart = System.nanoTime();
            result = new ArrayList<>();
            long sortTotal = 0;
            long searchTotal = 0;
            // Mesma ordenação e busca do módulo paralelo, mas arquivo por arquivo,
            // na thread que chamou Search (sem criar threads de busca).
            for (int i = 0; i < files.size(); i++) {
                long sortStart = System.nanoTime();
                List<Line> sorted = MergeSort.mergeSort(List.of(files.get(i)));
                long sortNs = System.nanoTime() - sortStart;
                long searchStart = System.nanoTime();
                result.addAll(BinarySearch.binarySearch(sorted, query));
                long searchNs = System.nanoTime() - searchStart;
                sortTotal += sortNs;
                searchTotal += searchNs;
                metrics.put("file." + i + ".sort_ns", sortNs);
                metrics.put("file." + i + ".search_ns", searchNs);
            }
            metrics.put("sort_main_thread_ns", sortTotal);
            metrics.put("search_main_thread_ns", searchTotal);
            metrics.put("processing_wall_ns", System.nanoTime() - processingStart);
            return result;
        } catch (IOException | RuntimeException | Error e) {
            failure = e;
            throw e;
        } finally {
            metrics.finish(result, failure);
        }
    }
}
