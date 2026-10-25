import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import utils.Line;
import utils.SearchUtils;

/**
 * Executa o SearchUtils.Search do módulo compilado junto com esta classe, sem a interface
 * Swing, e anota no manifesto qual log cada pesquisa gerou. Deve rodar na raiz do
 * repositório, como a MainWindow, para que o caminho do dataset e a pasta logs sejam os mesmos.
 */
public class ExecutorPesquisas {
    public static void main(String[] args) throws Exception {
        if (args.length != 9) {
            System.err.println("Uso: ExecutorPesquisas <campanha> <modulo> <p|g> <termo> <repeticoes> "
                    + "<manifesto.csv> <bloco> <condicao> <ordem_inicial>");
            System.exit(2);
        }
        String campanha = args[0];
        String modulo = args[1];
        String dataset = args[2];
        String termo = args[3];
        int repeticoes = Integer.parseInt(args[4]);
        Path manifesto = Path.of(args[5]);
        String bloco = args[6];
        String condicao = args[7];
        int ordem = Integer.parseInt(args[8]);
        // Mesmo caminho relativo que a MainWindow do módulo envia para SearchUtils.Search.
        String caminho = "./" + modulo + "/datasets/" + dataset;
        Path logs = Path.of("logs");
        long pid = ProcessHandle.current().pid();

        for (int repeticao = 1; repeticao <= repeticoes; repeticao++, ordem++) {
            Set<Path> anteriores = listarLogs(logs);
            String inicio = OffsetDateTime.now().toString();
            long t0 = System.nanoTime();
            var resultado = SearchUtils.Search(caminho, termo);
            long externoNs = System.nanoTime() - t0;

            // A listagem fica fora de total_ns: serve só para achar o log desta pesquisa.
            Set<Path> novos = listarLogs(logs);
            novos.removeAll(anteriores);
            if (novos.size() != 1) {
                throw new IllegalStateException("Esperava 1 log novo e encontrei " + novos.size() + ": " + novos);
            }
            List<String> encontrados = new ArrayList<>();
            for (Line linha : resultado) {
                encontrados.add(linha.file() + ":" + linha.line());
            }
            String registro = String.join(",", campanha, String.valueOf(ordem), bloco, condicao, modulo,
                    dataset, termo, String.valueOf(repeticao), String.valueOf(pid),
                    novos.iterator().next().getFileName().toString(), String.valueOf(resultado.size()),
                    String.join(";", encontrados), String.valueOf(externoNs), inicio);
            Files.writeString(manifesto, registro + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.printf("%3d  %-30s %s  %-13s rep %2d  %9.3f ms  %s%n", ordem, modulo,
                    dataset.toUpperCase(), termo, repeticao, externoNs / 1e6,
                    encontrados.isEmpty() ? "(sem resultado)" : String.join(" ", encontrados));
        }
    }

    private static Set<Path> listarLogs(Path logs) throws IOException {
        Set<Path> resultado = new HashSet<>();
        try (Stream<Path> arquivos = Files.list(logs)) {
            arquivos.filter(p -> p.getFileName().toString().endsWith(".properties")).forEach(resultado::add);
        } catch (NoSuchFileException e) {
            // A pasta é criada pelo SearchMetrics na primeira gravação.
        }
        return resultado;
    }
}
