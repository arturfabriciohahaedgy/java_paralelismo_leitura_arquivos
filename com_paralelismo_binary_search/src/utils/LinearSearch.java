package utils;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    // Retorna as linhas em que alguma palavra do name começa com query (como LIKE 'query%'),
    // sem diferenciar maiúsculas.
    public static ArrayList<Line> linearSearch(List<Line> lines, String query) {
        ArrayList<Line> result = new ArrayList<Line>();

        // Olha linha por linha, do começo ao fim
        for (Line l : lines) {
            if (l.name().trim().equals(query)) {
//            for (String word : l.name().split(" ")) {
//                if (word.regionMatches(true, 0, query, 0, query.length())) {
                    result.add(l);
                    break; // Já casou nesta linha, não precisa olhar as outras palavras
//                }
            }
        }

        return result;
    }

    // Dispara uma thread por arquivo, espera todas terminarem e concatena os resultados
    public static List<Line> parallelLinearSearch(List<List<Line>> files, String query) throws InterruptedException {
        List<SearchThread> threads = new ArrayList<SearchThread>();

        // Cria e inicia uma thread para cada arquivo
        for (List<Line> fileLines : files) {
            SearchThread t = new SearchThread(fileLines, query);
            threads.add(t);
            t.start();
        }

        // Espera cada thread e junta o que ela encontrou
        List<Line> result = new ArrayList<Line>();
        for (SearchThread t : threads) {
            t.join();
            result.addAll(t.getResult());
        }

        return result;
    }
}
