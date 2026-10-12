package src.utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchUtils {
    public static ArrayList<Line> Search(String path, String query) throws IOException {
        List<Line> lines = new ArrayList<Line>();
        List<ArrayList<Line>> files = new ArrayList<>();
        for (Path file : src.utils.FileUtils.listFiles(path)) {
            files.add((ArrayList<Line>) FileUtils.readAllLines(file));
        }
        List<Line> sortedLines = MergeSort.mergeSort(files);
        return LinearSearch.linearSearch(sortedLines, query);
    }
}
