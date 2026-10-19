package utils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SearchUtils {
    public static ArrayList<Line> Search(String path, String query) throws IOException {
        List<Line> files = new ArrayList<>();
        for (Path file : utils.FileUtils.listFiles(path)) {
            files.addAll(FileUtils.readAllLines(file));
        }
        return LinearSearch.linearSearch(files, query);
    }
}
