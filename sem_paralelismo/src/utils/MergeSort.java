package src.utils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<Line> mergeSort(List<? extends List<Line>> files) {
        // Junta as linhas de todos os arquivos numa lista só
        List<Line> lines = new ArrayList<Line>();
        for (List<Line> file : files) {
            lines.addAll(file);
        }

        return sort(lines);
    }

    private static List<Line> sort(List<Line> lines) {
        // Lista com 0 ou 1 linha já está ordenada
        if (lines.size() <= 1) {
            return lines;
        }

        // Divide ao meio e ordena cada metade
        int middle = lines.size() / 2;
        List<Line> left = sort(lines.subList(0, middle));
        List<Line> right = sort(lines.subList(middle, lines.size()));

        return merge(left, right);
    }

    private static List<Line> merge(List<Line> left, List<Line> right) {
        List<Line> result = new ArrayList<Line>();
        int i = 0;
        int j = 0;

        // Compara o texto do primeiro de cada lado e pega o menor
        while (i < left.size() && j < right.size()) {
            if (left.get(i).name().compareToIgnoreCase(right.get(j).name()) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Copia o que sobrou
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));
        return result;
    }
}
