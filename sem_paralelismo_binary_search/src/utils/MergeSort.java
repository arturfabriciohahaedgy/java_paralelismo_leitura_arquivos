package utils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<Line> mergeSort(List<? extends List<Line>> files) {
        // Junta as linhas de todos os arquivos numa lista só.
        List<Line> lines = new ArrayList<Line>();
        for (List<Line> file : files) {
            lines.addAll(file);
        }

        return sort(lines);
    }

    private static List<Line> sort(List<Line> lines) {
        if (lines.size() <= 1) {
            return lines;
        }

        int middle = lines.size() / 2;
        List<Line> left = sort(lines.subList(0, middle));
        List<Line> right = sort(lines.subList(middle, lines.size()));

        return merge(left, right);
    }

    private static List<Line> merge(List<Line> left, List<Line> right) {
        List<Line> result = new ArrayList<Line>();
        int i = 0;
        int j = 0;

        // Mesmo critério da busca binária; empates preservam a ordem original.
        while (i < left.size() && j < right.size()) {
            if (left.get(i).name().trim().compareTo(right.get(j).name().trim()) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }
}
