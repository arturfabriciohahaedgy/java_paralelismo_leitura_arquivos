package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SearchUtils {
    public static ArrayList<Line> Search(String path, String query) throws IOException {
        SearchMetrics metrics = new SearchMetrics("sem_paralelismo", path, query,
                "linear", "first_match_global");
        ArrayList<Line> result = null;
        Throwable failure = null;
        try {
            long readStart = System.nanoTime();
            List<Path> paths = FileUtils.listFiles(path);
            metrics.put("file_count", paths.size());
            metrics.put("worker_threads", 0);
            metrics.put("sorting_enabled", false);
            List<Line> lines = new ArrayList<>();
            long bytes = 0;
            for (int i = 0; i < paths.size(); i++) {
                Path file = paths.get(i);
                long fileStart = System.nanoTime();
                List<Line> loaded = FileUtils.readAllLines(file);
                long readNs = System.nanoTime() - fileStart;
                long size = Files.size(file);
                metrics.file(i, file, loaded.size(), size, readNs);
                bytes += size;
                lines.addAll(loaded);
            }
            metrics.put("read_wall_ns", System.nanoTime() - readStart);
            metrics.put("dataset_bytes", bytes);
            metrics.put("loaded_lines", lines.size());
            long searchStart = System.nanoTime();
            result = LinearSearch.linearSearch(lines, query);
            long searchNs = System.nanoTime() - searchStart;
            metrics.put("processing_wall_ns", searchNs);
            metrics.put("search_main_thread_ns", searchNs);
            return result;
        } catch (IOException | RuntimeException | Error e) {
            failure = e;
            throw e;
        } finally {
            metrics.finish(result, failure);
        }
    }
}
