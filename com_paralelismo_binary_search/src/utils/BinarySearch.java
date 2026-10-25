package utils;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    // Recebe linhas ordenadas por name().trim(), diferenciando maiúsculas.
    // Retorna apenas a primeira ocorrência, como a busca linear do projeto.
    public static ArrayList<Line> binarySearch(List<Line> lines, String query) {
        ArrayList<Line> result = new ArrayList<Line>();
        int left = 0;
        int right = lines.size();

        // Localiza a primeira posição cujo nome é maior ou igual à consulta.
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (lines.get(middle).name().trim().compareTo(query) < 0) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (left < lines.size() && lines.get(left).name().trim().equals(query)) {
            result.add(lines.get(left));
        }
        return result;
    }

    // Ordena com MergeSort e busca em uma thread por arquivo.
    public static List<Line> parallelBinarySearch(List<List<Line>> files, String query)
            throws InterruptedException {
        return parallelBinarySearch(files, query, null);
    }

    public static List<Line> parallelBinarySearch(List<List<Line>> files, String query,
            SearchMetrics metrics) throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>();
        List<List<Line>> results = new ArrayList<List<Line>>();

        for (List<Line> fileLines : files) {
            List<Line> found = new ArrayList<Line>();
            results.add(found);
            int index = threads.size();
            Thread thread = new Thread(() -> {
                long sortStart = System.nanoTime();
                List<Line> sortedLines = MergeSort.mergeSort(List.of(fileLines));
                long sortNs = System.nanoTime() - sortStart;
                long searchStart = System.nanoTime();
                found.addAll(binarySearch(sortedLines, query));
                long searchNs = System.nanoTime() - searchStart;
                if (metrics != null) {
                    metrics.workerTimes(sortNs, searchNs);
                    metrics.put("file." + index + ".sort_ns", sortNs);
                    metrics.put("file." + index + ".search_ns", searchNs);
                }
            });
            threads.add(thread);
            thread.start();
        }

        List<Line> result = new ArrayList<Line>();
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).join();
            result.addAll(results.get(i));
        }
        return result;
    }
}
