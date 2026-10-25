# Métricas de busca

Cada chamada a `SearchUtils.Search` gera um arquivo UTF-8:

```
logs/AAAA-MM-DD-HH-mm-ss-nanos-nome_modulo.properties
```

A pasta é compartilhada pelos quatro módulos na raiz do repositório. É localizada
pelos ancestrais do dataset; para datasets externos, usa-se o diretório de execução.
Os arquivos de medições são ignorados pelo Git. O formato pode ser carregado com
`Properties.load(Reader)` no Java. Consultas e nomes encontrados são registrados:
considere isso antes de compartilhar logs com dados pessoais.

## Campos

- `module`, `algorithm`, `dataset`, `query`, `comparison`, `result_policy`:
  identificação e regras da consulta.
- `status`, `error_type`, `error_message`: sucesso ou falha.
- `file_count`, `dataset_bytes`, `loaded_lines`: volume carregado.
- `file.N.path/bytes/lines/read_ns`: dados e tempo de leitura de cada arquivo,
  na ordem efetivamente fornecida pelo sistema de arquivos.
- `read_wall_ns`: leitura, listagem, obtenção de tamanhos, montagem das listas e
  instrumentação dessa fase. `file.N.read_ns` mede somente `readAllLines`.
- `processing_wall_ns`: busca sequencial ou criação das threads, execução,
  espera e concatenação. Nos módulos binários **inclui o MergeSort**.
- `total_ns`: leitura e processamento, incluindo instrumentação; exclui
  inicialização do coletor, gravação do log e atualização da interface.
- `search_main_thread_ns`: tempo de busca nos módulos sequenciais (soma por arquivo no binário).
- `sort_main_thread_ns`: soma dos tempos de MergeSort no binário sequencial.
- `worker_threads`: threads de busca previstas (zero nos sequenciais).
- `file.N.search_ns`: busca por arquivo nos módulos binários e paralelos.
- `file.N.sort_ns`: MergeSort por arquivo nos módulos binários.
- `search_workers_sum_ns`, `sort_workers_sum_ns`: soma dos tempos das threads;
  **não são tempo de parede**, pois as threads podem executar simultaneamente.
  São zero nos sequenciais; ordenação é zero nos módulos lineares.
- `sorting_enabled`: se há ordenação antes da consulta.
- `result_count`, `result.N.file/line/name`: resultados para conferir correção.
- `heap_before_bytes`, `heap_after_bytes`, `heap_delta_bytes`, `heap_max_bytes`:
  amostras do heap da JVM; **não** medem pico nem total de alocações. O delta
  pode ser negativo por causa do GC. Nenhum GC é forçado.
- `process_cpu_ns`: CPU de todo o processo no intervalo; `-1` se indisponível.
- `gc_count_delta`, `gc_time_delta_ms`: atividade dos coletores na JVM.
- `java_version`, `java_vm`, `os`, `os_arch`, `available_processors`,
  `jvm_uptime_start_ms`: ambiente de execução.

Em falhas, alguns campos podem não existir porque a fase não terminou. Logs de
consultas interrompidas não devem ser usados como amostras de desempenho.
Falhas de gravação são avisadas em stderr e não alteram o retorno da busca.

## Comparação justa

O sequencial linear retorna a primeira ocorrência **global**; os módulos paralelos
e o binário sequencial retornam a primeira ocorrência **por arquivo**.
Portanto, quantidade de resultados e quantidade de trabalho podem ser distintas.
Use nomes únicos no dataset, ou consultas ausentes, ao comparar esses fluxos.

Compare `total_ns` para o custo completo e `processing_wall_ns` para a fase de
processamento. Não compare a soma dos tempos das threads com o tempo sequencial
como se fosse latência. A ordenação binária ocorre novamente a cada consulta.

Repita consultas nos mesmos dados, confira os resultados, aqueça a JVM e separe
as primeiras execuções das demais. Execute um módulo por vez, sem outras cargas,
e reporte mediana e dispersão, além de média. O cache do sistema operacional,
JIT, GC e a própria instrumentação influenciam os números. CPU, memória e GC
incluem outras atividades da JVM (por exemplo, Swing). Speedup e eficiência
podem ser calculados posteriormente com amostras equivalentes; não são inferidos
automaticamente a partir de uma consulta isolada.
