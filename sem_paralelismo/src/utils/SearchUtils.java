package src.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchUtils {
    public static void Search(String path) throws IOException {
        List<String> lines = new ArrayList<String>();
        List<ArrayList<String>> files = new ArrayList<ArrayList<String>>();
        for (String file : src.utils.FileUtils.listFiles(path)) {
            files.add((ArrayList<String>) FileUtils.readAllLines(file));
        }
        List<String> sortedLines = MergeSort.mergeSort(lines);
        System.out.println(sortedLines);
        System.out.println(files);
    }
}
