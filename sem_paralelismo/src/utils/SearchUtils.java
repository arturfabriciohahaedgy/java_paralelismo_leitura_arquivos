package src.src.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchUtils {
    public static void Search(String path) throws IOException {
        List<String> lines = new ArrayList<String>();
        for (String file : src.utils.FileUtils.listFiles(path)) {
            lines.addAll(src.utils.FileUtils.readAllLines(file));
        }
        List<String> sortedLines = MergeSort.mergeSort(lines);
    }
}
