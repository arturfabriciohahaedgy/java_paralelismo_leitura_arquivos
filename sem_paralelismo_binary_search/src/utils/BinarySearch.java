package utils;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    // Recebe linhas ordenadas por name().trim(), diferenciando maiúsculas.
    // Retorna somente a primeira ocorrência do arquivo.
    public static ArrayList<Line> binarySearch(List<Line> lines, String query) {
        ArrayList<Line> result = new ArrayList<>();
        int left = 0;
        int right = lines.size();

        // Localiza a primeira posição cujo nome é maior ou igual à consulta.
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (lines.get(middle).name().trim().compareTo(query) < 0) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        if (left < lines.size() && lines.get(left).name().trim().equals(query)) {
            result.add(lines.get(left));
        }
        return result;
    }
}
