package src.utils;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUtils {
    public static List<Line> readAllLines(Path path) throws FileNotFoundException, IOException {
        List<Line> lines = new ArrayList<Line>();
        String fileName = String.valueOf(path.getFileName());
        int currentLine = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)))) {
            String l;
            while ((l = reader.readLine()) != null) {
                lines.add(new Line(fileName, currentLine++, l));
            }
        }

        return lines;
    }

    public static List<Path> listFiles(String dirPath) {
        ArrayList<Path> list = new ArrayList<Path>();
        File dir = new File(dirPath);

        for (File f : Objects.requireNonNull(dir.listFiles())) {
            if (f.getName().contains("."))
                list.add(Path.of(dirPath + "/" + f.getName()));
        }

        return list;
    }
}
