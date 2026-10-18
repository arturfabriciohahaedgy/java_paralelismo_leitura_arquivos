package src.utils;

import java.util.List;

// Thread que faz a busca linear nas linhas de um único arquivo
public class SearchThread extends Thread {
    private final List<Line> lines;
    private final String query;
    private List<Line> result;

    public SearchThread(List<Line> lines, String query) {
        this.lines = lines;
        this.query = query;
    }

    @Override
    public void run() {
        result = LinearSearch.linearSearch(lines, query);
    }

    public List<Line> getResult() {
        return result;
    }
}
