package src.utils;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    // Retorna as linhas em que alguma palavra do name começa com query (como LIKE 'query%'),
    // sem diferenciar maiúsculas.
    public static ArrayList<Line> linearSearch(List<Line> lines, String query) {
        ArrayList<Line> result = new ArrayList<Line>();

        // Olha linha por linha, do começo ao fim
        for (Line l : lines) {
            for (String word : l.name().split(" ")) {
                if (word.regionMatches(true, 0, query, 0, query.length())) {
                    result.add(l);
                    break; // Já casou nesta linha, não precisa olhar as outras palavras
                }
            }
        }

        return result;
    }
}
