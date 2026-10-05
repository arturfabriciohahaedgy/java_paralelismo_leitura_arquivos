package src.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUtils {
    public static List<String> readAllLines(String path) throws FileNotFoundException, IOException {
        List<String> lines = new ArrayList<String>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String l;
            while ((l = reader.readLine()) != null) {
                lines.add(l);
            }
        }

        return lines;
    }

    public static List<String> listFiles(String dirPath) {
        ArrayList<String> list = new ArrayList<String>();
        File dir = new File(dirPath);

        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.getName().contains("."))
                list.add(f.getName());
        }

        return list;
    }
}
