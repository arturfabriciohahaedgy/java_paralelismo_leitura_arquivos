package src.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SearchUtils {
    public static List<Line> Search(String path, String query) throws IOException, InterruptedException {
        // Uma lista de linhas para cada arquivo
        List<List<Line>> files = new ArrayList<List<Line>>();
        for (Path file : FileUtils.listFiles(path)) {
            files.add(FileUtils.readAllLines(file));
        }

        // Uma thread por arquivo, já volta tudo concatenado
        List<Line> found = LinearSearch.parallelLinearSearch(files, query);

        // Ordena só o que foi encontrado
        return MergeSort.mergeSort(List.of(found));
    }
}
