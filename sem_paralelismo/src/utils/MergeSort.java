package src.utils;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<String> mergeSort(List<String> lines) {
        // Lista com 0 ou 1 linha já está ordenada
        if (lines.size() <= 1) {
            return lines;
        }

        // Divide ao meio e ordena cada metade
        int middle = lines.size() / 2;
        List<String> left = mergeSort(lines.subList(0, middle));
        List<String> right = mergeSort(lines.subList(middle, lines.size()));

        return merge(left, right);
    }

    private static List<String> merge(List<String> left, List<String> right) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        int j = 0;

        // Compara o primeiro de cada lado e pega o menor
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
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
