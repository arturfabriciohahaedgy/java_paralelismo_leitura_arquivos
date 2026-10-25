package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SearchUtils {
    public static List<Line> Search(String path, String query) throws IOException, InterruptedException {
        SearchMetrics metrics = new SearchMetrics("com_paralelismo", path, query,
                "parallel_linear", "first_match_per_file");
        List<Line> result = null;
        Throwable failure = null;
        try {
            long readStart = System.nanoTime();
            List<Path> paths = FileUtils.listFiles(path);
            metrics.put("file_count", paths.size());
            metrics.put("worker_threads", paths.size());
            metrics.put("sorting_enabled", false);
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
            long searchStart = System.nanoTime();
            result = LinearSearch.parallelLinearSearch(files, query, metrics);
            metrics.put("processing_wall_ns", System.nanoTime() - searchStart);
            return result;
        } catch (IOException | InterruptedException | RuntimeException | Error e) {
            failure = e;
            throw e;
        } finally {
            metrics.finish(result, failure);
        }
    }
}
