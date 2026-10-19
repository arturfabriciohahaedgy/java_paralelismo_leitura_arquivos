package utils;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static ArrayList<Line> linearSearch(List<Line> lines, String query) {
        ArrayList<Line> result = new ArrayList<Line>();

        // Olha linha por linha, do começo ao fim
        for (Line l : lines) {
                if (l.name().trim().equals(query)) {
                    result.add(l);
                    break; // Já casou nesta linha, não precisa olhar as outras palavras
//                }
            }
        }

        return result;
    }
}
