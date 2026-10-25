<!-- Gerado por analise/processar_logs.py a partir dos logs da campanha 2026-10-25_172153. -->

### Resultados individuais — Linear sem threads (`sem_paralelismo`), tempos em ms

| Dataset | Termo | Resultado | Mediana total | Q1 – Q3 | Média ± DP | CV % | CV % 2ª–10ª | Mín. – Máx. | 1ª (fria) | Mediana 2ª–10ª | Mediana leitura | Mediana processamento |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| P | Kelly Fields | arq_1.txt:5 | 2,84 | 2,61 – 3,11 | 3,87 ± 2,86 | 73,9 | 22,5 | 2,49 – 11,79 | 11,79 | 2,82 | 2,83 | 0,006 |
| P | Tyler Barrera | ausente | 3,37 | 3,17 – 3,57 | 4,43 ± 3,51 | 79,1 | 9,8 | 2,80 – 14,37 | 14,37 | 3,35 | 2,98 | 0,381 |
| P | Sara White | arq_1.txt:1000 | 2,91 | 2,79 – 3,35 | 3,87 ± 2,87 | 74,1 | 12,3 | 2,59 – 11,97 | 11,97 | 2,81 | 2,81 | 0,095 |
| G | Kelly Fields | a1.txt:1204 | 8,16 | 7,18 – 11,72 | 11,14 ± 7,56 | 67,9 | 24,8 | 6,97 – 31,85 | 31,85 | 7,80 | 8,02 | 0,110 |
| G | Tyler Barrera | a5.txt:10000 | 8,93 | 7,42 – 13,11 | 12,17 ± 8,39 | 68,9 | 29,6 | 7,02 – 34,77 | 34,77 | 8,38 | 8,43 | 0,526 |
| G | Sara White | a6.txt:2680 | 9,06 | 7,43 – 13,75 | 13,21 ± 11,24 | 85,1 | 36,9 | 6,63 – 43,68 | 43,68 | 8,16 | 8,56 | 0,437 |

### Resultados individuais — Linear com threads (`com_paralelismo`), tempos em ms

| Dataset | Termo | Resultado | Mediana total | Q1 – Q3 | Média ± DP | CV % | CV % 2ª–10ª | Mín. – Máx. | 1ª (fria) | Mediana 2ª–10ª | Mediana leitura | Mediana processamento |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| P | Kelly Fields | arq_1.txt:5 | 4,09 | 3,49 – 5,07 | 5,20 ± 3,09 | 59,3 | 29,7 | 3,08 – 13,29 | 13,29 | 4,03 | 3,09 | 1,030 |
| P | Tyler Barrera | ausente | 3,71 | 3,27 – 4,80 | 4,98 ± 3,33 | 66,8 | 24,7 | 3,14 – 14,09 | 14,09 | 3,36 | 3,12 | 0,761 |
| P | Sara White | arq_1.txt:1000 | 4,06 | 3,54 – 4,59 | 5,03 ± 3,25 | 64,6 | 16,7 | 3,13 – 14,10 | 14,10 | 3,94 | 2,85 | 1,112 |
| G | Kelly Fields | a1.txt:1204 | 10,11 | 9,09 – 15,44 | 13,98 ± 9,12 | 65,3 | 29,8 | 8,11 – 38,33 | 38,33 | 9,57 | 8,20 | 2,053 |
| G | Tyler Barrera | a5.txt:10000 | 12,23 | 9,43 – 14,74 | 14,70 ± 8,77 | 59,7 | 27,3 | 8,56 – 38,04 | 38,04 | 11,22 | 9,36 | 1,561 |
| G | Sara White | a6.txt:2680 | 10,54 | 9,03 – 15,87 | 14,41 ± 9,27 | 64,4 | 31,0 | 8,28 – 38,95 | 38,95 | 10,34 | 8,87 | 1,877 |

### Resultados individuais — Binária sem threads (`sem_paralelismo_binary_search`), tempos em ms

| Dataset | Termo | Resultado | Mediana total | Q1 – Q3 | Média ± DP | CV % | CV % 2ª–10ª | Mín. – Máx. | 1ª (fria) | Mediana 2ª–10ª | Mediana leitura | Mediana processamento |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| P | Kelly Fields | arq_1.txt:5 | 7,98 | 7,66 – 8,46 | 9,59 ± 5,09 | 53,1 | 5,3 | 7,59 – 24,03 | 24,03 | 7,96 | 2,63 | 5,279 |
| P | Tyler Barrera | ausente | 8,78 | 8,43 – 9,71 | 11,61 ± 6,52 | 56,2 | 28,5 | 8,32 – 28,61 | 28,61 | 8,53 | 3,15 | 5,650 |
| P | Sara White | arq_1.txt:1000 | 8,94 | 7,27 – 10,16 | 10,62 ± 7,40 | 69,7 | 29,4 | 4,99 – 30,61 | 30,61 | 8,31 | 3,56 | 5,497 |
| G | Kelly Fields | a1.txt:1204 | 51,65 | 47,74 – 62,44 | 64,35 ± 29,70 | 46,2 | 26,8 | 45,15 – 138,62 | 138,62 | 51,56 | 10,35 | 42,673 |
| G | Tyler Barrera | a5.txt:10000 | 51,30 | 48,10 – 55,29 | 64,97 ± 35,19 | 54,2 | 27,6 | 44,44 – 156,51 | 156,51 | 51,14 | 8,55 | 42,049 |
| G | Sara White | a6.txt:2680 | 52,51 | 50,50 – 55,91 | 64,51 ± 30,25 | 46,9 | 28,3 | 45,16 – 139,32 | 139,32 | 52,38 | 8,59 | 43,774 |

### Resultados individuais — Binária com threads (`com_paralelismo_binary_search`), tempos em ms

| Dataset | Termo | Resultado | Mediana total | Q1 – Q3 | Média ± DP | CV % | CV % 2ª–10ª | Mín. – Máx. | 1ª (fria) | Mediana 2ª–10ª | Mediana leitura | Mediana processamento |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| P | Kelly Fields | arq_1.txt:5 | 13,24 | 12,72 – 13,92 | 13,87 ± 6,55 | 47,2 | 29,3 | 5,23 – 29,90 | 29,90 | 12,96 | 2,92 | 10,156 |
| P | Tyler Barrera | ausente | 13,83 | 13,05 – 14,36 | 13,89 ± 7,41 | 53,3 | 33,9 | 4,47 – 31,99 | 31,99 | 13,79 | 3,42 | 10,333 |
| P | Sara White | arq_1.txt:1000 | 14,56 | 5,59 – 17,48 | 14,03 ± 9,27 | 66,1 | 57,4 | 4,38 – 32,97 | 32,97 | 13,64 | 4,00 | 9,019 |
| G | Kelly Fields | a1.txt:1204 | 35,85 | 30,25 – 37,17 | 67,47 ± 78,47 | 116,3 | 100,3 | 20,58 – 251,52 | 251,52 | 34,63 | 12,52 | 21,844 |
| G | Tyler Barrera | a5.txt:10000 | 49,61 | 41,01 – 93,05 | 78,37 ± 68,45 | 87,3 | 56,2 | 24,50 – 251,54 | 251,54 | 42,98 | 8,85 | 41,231 |
| G | Sara White | a6.txt:2680 | 138,04 | 118,73 – 256,53 | 184,72 ± 97,28 | 52,7 | 56,3 | 75,18 – 334,42 | 258,59 | 138,00 | 12,40 | 126,749 |

### Tempo total por pesquisa (ms) — `total_ns`

| Projeto | Dataset | Termo | n | Média | DP | CV % | Mediana | Q1 – Q3 | Mín. | Máx. | 1ª (fria) | Mediana 2ª–10ª | CV % 2ª–10ª |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Linear sem threads | P | Kelly Fields | 10 | 3,87 | 2,86 | 73,9 | 2,84 | 2,61 – 3,11 | 2,49 | 11,79 | 11,79 | 2,82 | 22,5 |
| Linear sem threads | P | Tyler Barrera | 10 | 4,43 | 3,51 | 79,1 | 3,37 | 3,17 – 3,57 | 2,80 | 14,37 | 14,37 | 3,35 | 9,8 |
| Linear sem threads | P | Sara White | 10 | 3,87 | 2,87 | 74,1 | 2,91 | 2,79 – 3,35 | 2,59 | 11,97 | 11,97 | 2,81 | 12,3 |
| Linear sem threads | G | Kelly Fields | 10 | 11,14 | 7,56 | 67,9 | 8,16 | 7,18 – 11,72 | 6,97 | 31,85 | 31,85 | 7,80 | 24,8 |
| Linear sem threads | G | Tyler Barrera | 10 | 12,17 | 8,39 | 68,9 | 8,93 | 7,42 – 13,11 | 7,02 | 34,77 | 34,77 | 8,38 | 29,6 |
| Linear sem threads | G | Sara White | 10 | 13,21 | 11,24 | 85,1 | 9,06 | 7,43 – 13,75 | 6,63 | 43,68 | 43,68 | 8,16 | 36,9 |
| Linear com threads | P | Kelly Fields | 10 | 5,20 | 3,09 | 59,3 | 4,09 | 3,49 – 5,07 | 3,08 | 13,29 | 13,29 | 4,03 | 29,7 |
| Linear com threads | P | Tyler Barrera | 10 | 4,98 | 3,33 | 66,8 | 3,71 | 3,27 – 4,80 | 3,14 | 14,09 | 14,09 | 3,36 | 24,7 |
| Linear com threads | P | Sara White | 10 | 5,03 | 3,25 | 64,6 | 4,06 | 3,54 – 4,59 | 3,13 | 14,10 | 14,10 | 3,94 | 16,7 |
| Linear com threads | G | Kelly Fields | 10 | 13,98 | 9,12 | 65,3 | 10,11 | 9,09 – 15,44 | 8,11 | 38,33 | 38,33 | 9,57 | 29,8 |
| Linear com threads | G | Tyler Barrera | 10 | 14,70 | 8,77 | 59,7 | 12,23 | 9,43 – 14,74 | 8,56 | 38,04 | 38,04 | 11,22 | 27,3 |
| Linear com threads | G | Sara White | 10 | 14,41 | 9,27 | 64,4 | 10,54 | 9,03 – 15,87 | 8,28 | 38,95 | 38,95 | 10,34 | 31,0 |
| Binária sem threads | P | Kelly Fields | 10 | 9,59 | 5,09 | 53,1 | 7,98 | 7,66 – 8,46 | 7,59 | 24,03 | 24,03 | 7,96 | 5,3 |
| Binária sem threads | P | Tyler Barrera | 10 | 11,61 | 6,52 | 56,2 | 8,78 | 8,43 – 9,71 | 8,32 | 28,61 | 28,61 | 8,53 | 28,5 |
| Binária sem threads | P | Sara White | 10 | 10,62 | 7,40 | 69,7 | 8,94 | 7,27 – 10,16 | 4,99 | 30,61 | 30,61 | 8,31 | 29,4 |
| Binária sem threads | G | Kelly Fields | 10 | 64,35 | 29,70 | 46,2 | 51,65 | 47,74 – 62,44 | 45,15 | 138,62 | 138,62 | 51,56 | 26,8 |
| Binária sem threads | G | Tyler Barrera | 10 | 64,97 | 35,19 | 54,2 | 51,30 | 48,10 – 55,29 | 44,44 | 156,51 | 156,51 | 51,14 | 27,6 |
| Binária sem threads | G | Sara White | 10 | 64,51 | 30,25 | 46,9 | 52,51 | 50,50 – 55,91 | 45,16 | 139,32 | 139,32 | 52,38 | 28,3 |
| Binária com threads | P | Kelly Fields | 10 | 13,87 | 6,55 | 47,2 | 13,24 | 12,72 – 13,92 | 5,23 | 29,90 | 29,90 | 12,96 | 29,3 |
| Binária com threads | P | Tyler Barrera | 10 | 13,89 | 7,41 | 53,3 | 13,83 | 13,05 – 14,36 | 4,47 | 31,99 | 31,99 | 13,79 | 33,9 |
| Binária com threads | P | Sara White | 10 | 14,03 | 9,27 | 66,1 | 14,56 | 5,59 – 17,48 | 4,38 | 32,97 | 32,97 | 13,64 | 57,4 |
| Binária com threads | G | Kelly Fields | 10 | 67,47 | 78,47 | 116,3 | 35,85 | 30,25 – 37,17 | 20,58 | 251,52 | 251,52 | 34,63 | 100,3 |
| Binária com threads | G | Tyler Barrera | 10 | 78,37 | 68,45 | 87,3 | 49,61 | 41,01 – 93,05 | 24,50 | 251,54 | 251,54 | 42,98 | 56,2 |
| Binária com threads | G | Sara White | 10 | 184,72 | 97,28 | 52,7 | 138,04 | 118,73 – 256,53 | 75,18 | 334,42 | 258,59 | 138,00 | 56,3 |

### Fase de processamento (ms) — `processing_wall_ns`

| Projeto | Dataset | Termo | n | Média | DP | CV % | Mediana | Q1 – Q3 | Mín. | Máx. | 1ª (fria) | Mediana 2ª–10ª | CV % 2ª–10ª |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Linear sem threads | P | Kelly Fields | 10 | 0,080 | 0,226 | 282,9 | 0,006 | 0,005 – 0,012 | 0,004 | 0,722 | 0,722 | 0,006 | 73,8 |
| Linear sem threads | P | Tyler Barrera | 10 | 0,526 | 0,422 | 80,3 | 0,381 | 0,372 – 0,435 | 0,361 | 1,724 | 1,724 | 0,378 | 9,6 |
| Linear sem threads | P | Sara White | 10 | 0,225 | 0,347 | 154,5 | 0,095 | 0,091 – 0,163 | 0,073 | 1,203 | 1,203 | 0,093 | 47,6 |
| Linear sem threads | G | Kelly Fields | 10 | 0,206 | 0,308 | 149,5 | 0,110 | 0,090 – 0,129 | 0,089 | 1,081 | 1,081 | 0,109 | 19,4 |
| Linear sem threads | G | Tyler Barrera | 10 | 1,363 | 1,909 | 140,1 | 0,526 | 0,373 – 1,241 | 0,363 | 6,382 | 6,382 | 0,493 | 96,3 |
| Linear sem threads | G | Sara White | 10 | 1,245 | 1,848 | 148,4 | 0,437 | 0,365 – 0,604 | 0,325 | 5,957 | 5,957 | 0,402 | 120,8 |
| Linear com threads | P | Kelly Fields | 10 | 1,189 | 0,755 | 63,4 | 1,030 | 0,735 – 1,298 | 0,534 | 3,151 | 3,151 | 1,010 | 33,5 |
| Linear com threads | P | Tyler Barrera | 10 | 1,098 | 0,849 | 77,4 | 0,761 | 0,616 – 1,186 | 0,537 | 3,351 | 3,351 | 0,690 | 38,4 |
| Linear com threads | P | Sara White | 10 | 1,431 | 0,959 | 67,1 | 1,112 | 0,852 – 1,310 | 0,692 | 3,663 | 3,663 | 1,015 | 49,6 |
| Linear com threads | G | Kelly Fields | 10 | 2,985 | 2,513 | 84,2 | 2,053 | 0,948 – 4,904 | 0,779 | 7,223 | 7,223 | 1,580 | 85,4 |
| Linear com threads | G | Tyler Barrera | 10 | 2,855 | 2,432 | 85,2 | 1,561 | 1,027 – 4,431 | 0,904 | 7,591 | 7,591 | 1,341 | 80,8 |
| Linear com threads | G | Sara White | 10 | 3,054 | 2,810 | 92,0 | 1,877 | 0,883 – 5,011 | 0,749 | 8,909 | 8,909 | 0,946 | 84,4 |
| Binária sem threads | P | Kelly Fields | 10 | 6,109 | 2,669 | 43,7 | 5,279 | 5,083 – 5,521 | 5,011 | 13,679 | 13,679 | 5,143 | 4,5 |
| Binária sem threads | P | Tyler Barrera | 10 | 6,762 | 3,608 | 53,4 | 5,650 | 5,572 – 5,710 | 5,360 | 17,026 | 17,026 | 5,636 | 2,3 |
| Binária sem threads | P | Sara White | 10 | 6,251 | 4,488 | 71,8 | 5,497 | 3,938 – 6,136 | 2,335 | 18,023 | 18,023 | 5,297 | 37,4 |
| Binária sem threads | G | Kelly Fields | 10 | 52,142 | 23,551 | 45,2 | 42,673 | 39,130 – 47,991 | 38,355 | 111,034 | 111,034 | 41,393 | 26,2 |
| Binária sem threads | G | Tyler Barrera | 10 | 52,338 | 24,630 | 47,1 | 42,049 | 40,541 – 45,250 | 37,623 | 115,352 | 115,352 | 41,362 | 25,2 |
| Binária sem threads | G | Sara White | 10 | 52,630 | 22,988 | 43,7 | 43,774 | 42,366 – 45,478 | 37,836 | 110,144 | 110,144 | 43,702 | 25,1 |
| Binária com threads | P | Kelly Fields | 10 | 9,978 | 4,495 | 45,0 | 10,156 | 9,963 – 10,603 | 2,374 | 18,338 | 18,338 | 10,074 | 39,9 |
| Binária com threads | P | Tyler Barrera | 10 | 9,708 | 5,385 | 55,5 | 10,333 | 9,482 – 10,684 | 1,734 | 21,148 | 21,148 | 10,262 | 45,1 |
| Binária com threads | P | Sara White | 10 | 9,142 | 7,269 | 79,5 | 9,019 | 1,883 – 13,968 | 1,643 | 20,842 | 20,842 | 6,906 | 81,1 |
| Binária com threads | G | Kelly Fields | 10 | 53,886 | 71,256 | 132,2 | 21,844 | 20,764 – 27,266 | 13,747 | 215,386 | 215,386 | 21,328 | 127,2 |
| Binária com threads | G | Tyler Barrera | 10 | 65,850 | 60,706 | 92,2 | 41,231 | 32,252 – 80,350 | 17,642 | 219,257 | 219,257 | 33,966 | 60,7 |
| Binária com threads | G | Sara White | 10 | 158,918 | 78,264 | 49,2 | 126,749 | 106,159 – 222,804 | 62,183 | 292,411 | 220,506 | 126,085 | 52,5 |

### Fase de leitura (ms) — `read_wall_ns`

| Projeto | Dataset | Termo | n | Média | DP | CV % | Mediana | Q1 – Q3 | Mín. | Máx. | 1ª (fria) | Mediana 2ª–10ª | CV % 2ª–10ª |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Linear sem threads | P | Kelly Fields | 10 | 3,78 | 2,63 | 69,6 | 2,83 | 2,59 – 3,09 | 2,48 | 11,04 | 11,04 | 2,80 | 22,7 |
| Linear sem threads | P | Tyler Barrera | 10 | 3,89 | 3,08 | 79,2 | 2,98 | 2,75 – 3,17 | 2,42 | 12,60 | 12,60 | 2,97 | 10,6 |
| Linear sem threads | P | Sara White | 10 | 3,63 | 2,52 | 69,3 | 2,81 | 2,58 – 3,18 | 2,50 | 10,73 | 10,73 | 2,71 | 12,7 |
| Linear sem threads | G | Kelly Fields | 10 | 10,89 | 7,25 | 66,6 | 8,02 | 7,03 – 11,55 | 6,83 | 30,70 | 30,70 | 7,67 | 24,9 |
| Linear sem threads | G | Tyler Barrera | 10 | 10,75 | 6,54 | 60,8 | 8,43 | 6,95 – 11,28 | 6,59 | 28,26 | 28,26 | 7,97 | 26,6 |
| Linear sem threads | G | Sara White | 10 | 11,91 | 9,45 | 79,3 | 8,56 | 7,03 – 12,56 | 6,28 | 37,55 | 37,55 | 7,68 | 33,2 |
| Linear com threads | P | Kelly Fields | 10 | 4,00 | 2,39 | 59,7 | 3,09 | 2,72 – 3,60 | 2,41 | 10,09 | 10,09 | 3,09 | 34,0 |
| Linear com threads | P | Tyler Barrera | 10 | 3,88 | 2,48 | 64,0 | 3,12 | 2,56 – 3,61 | 2,50 | 10,70 | 10,70 | 2,81 | 22,2 |
| Linear com threads | P | Sara White | 10 | 3,59 | 2,41 | 67,1 | 2,85 | 2,67 – 3,06 | 2,43 | 10,41 | 10,41 | 2,78 | 10,2 |
| Linear com threads | G | Kelly Fields | 10 | 10,95 | 7,19 | 65,7 | 8,20 | 7,77 – 10,46 | 7,06 | 31,05 | 31,05 | 8,16 | 16,5 |
| Linear com threads | G | Tyler Barrera | 10 | 11,80 | 6,83 | 57,9 | 9,36 | 8,27 – 12,35 | 7,58 | 30,39 | 30,39 | 8,84 | 21,7 |
| Linear com threads | G | Sara White | 10 | 11,31 | 6,82 | 60,3 | 8,87 | 7,73 – 11,44 | 7,28 | 29,95 | 29,95 | 8,31 | 22,1 |
| Binária sem threads | P | Kelly Fields | 10 | 3,48 | 2,43 | 69,8 | 2,63 | 2,51 – 3,04 | 2,40 | 10,33 | 10,33 | 2,63 | 11,4 |
| Binária sem threads | P | Tyler Barrera | 10 | 4,84 | 3,48 | 72,0 | 3,15 | 2,80 – 4,29 | 2,65 | 11,56 | 11,56 | 2,82 | 66,4 |
| Binária sem threads | P | Sara White | 10 | 4,36 | 2,98 | 68,4 | 3,56 | 2,73 – 4,37 | 2,60 | 12,56 | 12,56 | 3,50 | 23,7 |
| Binária sem threads | G | Kelly Fields | 10 | 12,16 | 6,51 | 53,6 | 10,35 | 7,22 – 14,88 | 6,75 | 27,52 | 27,52 | 10,12 | 36,9 |
| Binária sem threads | G | Tyler Barrera | 10 | 12,58 | 10,61 | 84,4 | 8,55 | 7,53 – 10,51 | 6,52 | 41,03 | 41,03 | 8,41 | 40,2 |
| Binária sem threads | G | Sara White | 10 | 11,85 | 7,31 | 61,7 | 8,59 | 7,94 – 10,57 | 7,28 | 29,12 | 29,12 | 8,03 | 43,5 |
| Binária com threads | P | Kelly Fields | 10 | 3,88 | 2,71 | 69,9 | 2,92 | 2,81 – 3,38 | 2,70 | 11,54 | 11,54 | 2,86 | 12,2 |
| Binária com threads | P | Tyler Barrera | 10 | 4,18 | 2,38 | 57,0 | 3,42 | 3,23 – 3,87 | 2,62 | 10,82 | 10,82 | 3,36 | 14,2 |
| Binária com threads | P | Sara White | 10 | 4,88 | 2,79 | 57,1 | 4,00 | 3,36 – 4,91 | 2,73 | 12,10 | 12,10 | 3,81 | 30,1 |
| Binária com threads | G | Kelly Fields | 10 | 13,54 | 8,56 | 63,2 | 12,52 | 8,13 – 14,18 | 6,80 | 36,06 | 36,06 | 12,24 | 31,3 |
| Binária com threads | G | Tyler Barrera | 10 | 12,48 | 7,99 | 64,0 | 8,85 | 7,84 – 13,32 | 6,81 | 32,22 | 32,22 | 8,73 | 40,8 |
| Binária com threads | G | Sara White | 10 | 25,75 | 31,50 | 122,3 | 12,40 | 10,14 – 26,56 | 9,32 | 110,82 | 37,95 | 11,84 | 135,7 |

### Visão geral por projeto e dataset (3 termos juntos, ms)

| Projeto | Dataset | n | Mediana total | Média total | CV % total | Mediana leitura | Mediana processamento | Processamento / total (%) | Mediana total 2ª–10ª |
| --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Linear sem threads | P | 30 | 3,06 | 4,06 | 73,8 | 2,88 | 0,099 | 3,2 | 3,01 |
| Linear sem threads | G | 30 | 8,45 | 12,17 | 73,3 | 8,18 | 0,376 | 4,4 | 8,16 |
| Linear com threads | P | 30 | 4,05 | 5,07 | 61,4 | 2,95 | 1,012 | 25,0 | 3,94 |
| Linear com threads | G | 30 | 10,69 | 14,36 | 60,9 | 8,66 | 1,681 | 15,7 | 10,34 |
| Binária sem threads | P | 30 | 8,43 | 10,61 | 58,8 | 2,82 | 5,561 | 66,0 | 8,39 |
| Binária sem threads | G | 30 | 51,78 | 64,61 | 47,5 | 8,92 | 43,583 | 84,2 | 51,56 |
| Binária com threads | P | 30 | 13,63 | 13,93 | 54,2 | 3,41 | 10,250 | 75,2 | 13,61 |
| Binária com threads | G | 30 | 72,43 | 110,19 | 87,0 | 11,24 | 62,084 | 85,7 | 56,25 |

### Sem threads × com threads — fase de processamento (ms; speedup = mediana sem ÷ mediana com)

| Algoritmo | Dataset | Termo | Threads | Mediana sem | Mediana com | Δ (com − sem) | Speedup | IC 95% (bootstrap) | Speedup 2ª–10ª | Speedup 1ª | p (Mann-Whitney) | p (Holm) | δ de Cliff | Eficiência |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Linear | P | Kelly Fields | 5 | 0,006 | 1,030 | 1,024 | **0,006** | 0,004 – 0,015 | 0,006 | 0,23 | < 0,001 | 0,005 | 0,94 (grande) | 0,001 |
| Linear | P | Tyler Barrera | 5 | 0,381 | 0,761 | 0,380 | **0,50** | 0,30 – 0,68 | 0,55 | 0,51 | 0,002 | 0,018 | 0,82 (grande) | 0,100 |
| Linear | P | Sara White | 5 | 0,095 | 1,112 | 1,016 | **0,086** | 0,051 – 0,18 | 0,092 | 0,33 | < 0,001 | 0,007 | 0,90 (grande) | 0,017 |
| Linear | P | (3 termos) | 5 | 0,099 | 1,012 | 0,914 | **0,097** | 0,070 – 0,38 | 0,096 | 0,36 | < 0,001 | – | 0,88 (grande) | 0,019 |
| Linear | G | Kelly Fields | 7 | 0,110 | 2,053 | 1,944 | **0,053** | 0,019 – 0,13 | 0,069 | 0,15 | < 0,001 | 0,006 | 0,92 (grande) | 0,009 |
| Linear | G | Tyler Barrera | 7 | 0,526 | 1,561 | 1,035 | **0,34** | 0,096 – 1,12 | 0,37 | 0,84 | 0,026 | 0,154 | 0,60 (grande) | 0,056 |
| Linear | G | Sara White | 7 | 0,437 | 1,877 | 1,440 | **0,23** | 0,078 – 0,69 | 0,43 | 0,67 | 0,009 | 0,064 | 0,70 (grande) | 0,039 |
| Linear | G | (3 termos) | 7 | 0,376 | 1,681 | 1,305 | **0,22** | 0,11 – 0,42 | 0,28 | 0,78 | < 0,001 | – | 0,74 (grande) | 0,037 |
| Binária | P | Kelly Fields | 5 | 5,279 | 10,156 | 4,877 | **0,52** | 0,44 – 0,75 | 0,51 | 0,75 | 0,076 | 0,303 | 0,48 (grande) | 0,104 |
| Binária | P | Tyler Barrera | 5 | 5,650 | 10,333 | 4,684 | **0,55** | 0,52 – 0,97 | 0,55 | 0,81 | 0,089 | 0,303 | 0,46 (médio) | 0,109 |
| Binária | P | Sara White | 5 | 5,497 | 9,019 | 3,522 | **0,61** | 0,31 – 3,19 | 0,77 | 0,86 | 0,791 | 1,000 | 0,08 (desprezível) | 0,122 |
| Binária | P | (3 termos) | 5 | 5,561 | 10,250 | 4,689 | **0,54** | 0,51 – 0,58 | 0,55 | 0,82 | 0,018 | – | 0,36 (médio) | 0,109 |
| Binária | G | Kelly Fields | 7 | 42,673 | 21,844 | -20,828 | **1,95** | 0,49 – 2,74 | 1,94 | 0,52 | 0,026 | 0,154 | -0,60 (grande) | 0,326 |
| Binária | G | Tyler Barrera | 7 | 42,049 | 41,231 | -0,818 | **1,02** | 0,48 – 1,58 | 1,22 | 0,53 | 0,678 | 1,000 | -0,12 (desprezível) | 0,170 |
| Binária | G | Sara White | 7 | 43,774 | 126,749 | 82,975 | **0,35** | 0,19 – 0,48 | 0,35 | 0,50 | < 0,001 | 0,006 | 0,92 (grande) | 0,058 |
| Binária | G | (3 termos) | 7 | 43,583 | 62,084 | 18,500 | **0,70** | 0,39 – 1,46 | 0,88 | 0,51 | 0,695 | – | 0,06 (desprezível) | 0,117 |

### Sem threads × com threads — tempo total (ms; speedup = mediana sem ÷ mediana com)

| Algoritmo | Dataset | Termo | Threads | Mediana sem | Mediana com | Δ (com − sem) | Speedup | IC 95% (bootstrap) | Speedup 2ª–10ª | Speedup 1ª | p (Mann-Whitney) | p (Holm) | δ de Cliff | Eficiência |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Linear | P | Kelly Fields | 5 | 2,84 | 4,09 | 1,25 | **0,70** | 0,49 – 0,91 | 0,70 | 0,89 | 0,014 | 0,140 | 0,66 (grande) | 0,139 |
| Linear | P | Tyler Barrera | 5 | 3,37 | 3,71 | 0,34 | **0,91** | 0,64 – 1,08 | 1,00 | 1,02 | 0,345 | 1,000 | 0,26 (pequeno) | 0,182 |
| Linear | P | Sara White | 5 | 2,91 | 4,06 | 1,15 | **0,72** | 0,60 – 0,91 | 0,71 | 0,85 | 0,007 | 0,080 | 0,72 (grande) | 0,143 |
| Linear | P | (3 termos) | 5 | 3,06 | 4,05 | 0,98 | **0,76** | 0,65 – 0,90 | 0,76 | 0,85 | < 0,001 | – | 0,59 (grande) | 0,152 |
| Linear | G | Kelly Fields | 7 | 8,16 | 10,11 | 1,94 | **0,81** | 0,49 – 1,25 | 0,82 | 0,83 | 0,121 | 0,849 | 0,42 (médio) | 0,135 |
| Linear | G | Tyler Barrera | 7 | 8,93 | 12,23 | 3,30 | **0,73** | 0,52 – 1,26 | 0,75 | 0,91 | 0,121 | 0,849 | 0,42 (médio) | 0,122 |
| Linear | G | Sara White | 7 | 9,06 | 10,54 | 1,48 | **0,86** | 0,48 – 1,44 | 0,79 | 1,12 | 0,186 | 0,929 | 0,36 (médio) | 0,143 |
| Linear | G | (3 termos) | 7 | 8,45 | 10,69 | 2,24 | **0,79** | 0,56 – 1,09 | 0,79 | 0,91 | 0,010 | – | 0,39 (médio) | 0,132 |
| Binária | P | Kelly Fields | 5 | 7,98 | 13,24 | 5,26 | **0,60** | 0,53 – 0,79 | 0,61 | 0,80 | 0,089 | 0,712 | 0,46 (médio) | 0,121 |
| Binária | P | Tyler Barrera | 5 | 8,78 | 13,83 | 5,05 | **0,64** | 0,59 – 1,00 | 0,62 | 0,89 | 0,241 | 0,965 | 0,32 (pequeno) | 0,127 |
| Binária | P | Sara White | 5 | 8,94 | 14,56 | 5,63 | **0,61** | 0,40 – 1,79 | 0,61 | 0,93 | 0,521 | 1,000 | 0,18 (pequeno) | 0,123 |
| Binária | P | (3 termos) | 5 | 8,43 | 13,63 | 5,20 | **0,62** | 0,58 – 0,70 | 0,62 | 0,89 | 0,030 | – | 0,33 (pequeno) | 0,124 |
| Binária | G | Kelly Fields | 7 | 51,65 | 35,85 | -15,80 | **1,44** | 0,51 – 2,15 | 1,49 | 0,55 | 0,026 | 0,232 | -0,60 (grande) | 0,240 |
| Binária | G | Tyler Barrera | 7 | 51,30 | 49,61 | -1,69 | **1,03** | 0,49 – 1,51 | 1,19 | 0,62 | 0,678 | 1,000 | -0,12 (desprezível) | 0,172 |
| Binária | G | Sara White | 7 | 52,51 | 138,04 | 85,54 | **0,38** | 0,19 – 0,55 | 0,38 | 0,54 | 0,002 | 0,020 | 0,84 (grande) | 0,063 |
| Binária | G | (3 termos) | 7 | 51,78 | 72,43 | 20,65 | **0,71** | 0,42 – 1,35 | 0,92 | 0,55 | 0,819 | – | 0,04 (desprezível) | 0,119 |

### Lei de Amdahl: teto de speedup do tempo total (leitura continua sequencial)

| Algoritmo | Dataset | Fração paralelizável (%) | Núcleos usáveis | Teto com esses núcleos | Teto com infinitos núcleos | Speedup total observado |
| --- | --- | ---: | ---: | ---: | ---: | ---: |
| Linear | P | 3,2 | 5 | 1,03 | 1,03 | 0,76 |
| Linear | G | 4,4 | 6 | 1,04 | 1,05 | 0,79 |
| Binária | P | 66,0 | 5 | 2,12 | 2,94 | 0,62 |
| Binária | G | 84,2 | 6 | 3,35 | 6,32 | 0,71 |

### Custo das threads (medianas, ms)

| Algoritmo | Dataset | Termo | Resultado | Linhas examinadas sem threads | Linhas examinadas com threads | Trabalho sem threads | Processamento com threads | Thread mais lenta | Criação/espera das threads | Paralelismo efetivo | Trabalho somado ÷ sem threads |
| --- | --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Linear | P | Kelly Fields | arq_1.txt:5 | 5 | 4.005 | 0,006 | 1,030 | 0,163 | 0,896 | 0,48 | 77,23 |
| Linear | P | Tyler Barrera | (nenhum) | 5.000 | 5.000 | 0,381 | 0,761 | 0,143 | 0,569 | 0,74 | 1,34 |
| Linear | P | Sara White | arq_1.txt:1000 | 1.000 | 5.000 | 0,095 | 1,112 | 0,148 | 0,799 | 0,54 | 5,35 |
| Linear | G | Kelly Fields | a1.txt:1204 | 1.204 | 61.204 | 0,110 | 2,053 | 1,070 | 0,845 | 1,75 | 40,02 |
| Linear | G | Tyler Barrera | a5.txt:10000 | 50.000 | 70.000 | 0,526 | 1,561 | 0,282 | 0,955 | 0,86 | 2,02 |
| Linear | G | Sara White | a6.txt:2680 | 52.680 | 62.680 | 0,437 | 1,877 | 0,651 | 0,779 | 1,44 | 7,15 |
| Binária | P | Kelly Fields | arq_1.txt:5 | 5.000 | 5.000 | 5,161 | 10,156 | 8,592 | 1,987 | 2,94 | 5,97 |
| Binária | P | Tyler Barrera | (nenhum) | 5.000 | 5.000 | 5,543 | 10,333 | 7,401 | 1,821 | 2,63 | 4,78 |
| Binária | P | Sara White | arq_1.txt:1000 | 5.000 | 5.000 | 5,384 | 9,019 | 3,011 | 1,933 | 1,60 | 2,10 |
| Binária | G | Kelly Fields | a1.txt:1204 | 70.000 | 70.000 | 42,513 | 21,844 | 16,702 | 4,479 | 3,54 | 1,70 |
| Binária | G | Tyler Barrera | a5.txt:10000 | 70.000 | 70.000 | 41,881 | 41,231 | 34,803 | 10,172 | 2,81 | 2,99 |
| Binária | G | Sara White | a6.txt:2680 | 70.000 | 70.000 | 43,618 | 126,749 | 41,383 | 71,974 | 0,85 | 2,25 |

### Métricas complementares (30 pesquisas por linha)

| Projeto | Dataset | Coletas de GC | Tempo de GC (ms) | CPU ÷ tempo (2ª–10ª) | Ticks de CPU (2ª–10ª) | Δ heap mediano (MiB) | Gravação do log + métricas (ms) | Total − leitura − processamento (ms) |
| --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Linear sem threads | P | 0 | 0 | 2,62 | 14 | 0,9 | 3,25 | 0,009 |
| Linear sem threads | G | 3 | 9 | 1,78 | 29 | 7,9 | 2,93 | 0,044 |
| Linear com threads | P | 1 | 1 | 2,40 | 17 | 4,0 | 3,27 | 0,005 |
| Linear com threads | G | 3 | 7 | 2,67 | 54 | 12,0 | 3,06 | 0,033 |
| Binária sem threads | P | 0 | 0 | 3,46 | 52 | 2,0 | 3,72 | 0,004 |
| Binária sem threads | G | 9 | 36 | 2,47 | 238 | 29,0 | 3,63 | 0,033 |
| Binária com threads | P | 2 | 4 | 4,16 | 86 | 4,8 | 3,58 | 0,008 |
| Binária com threads | G | 9 | 108 | 2,03 | 330 | 31,3 | 5,48 | 0,036 |

### Controle: leitura é o mesmo código nos 4 projetos (mediana, ms)

| Dataset | Linear sem threads | Linear com threads | Binária sem threads | Binária com threads | p (Kruskal-Wallis) | ρ ordem × leitura (2ª–10ª) | p (ρ) |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| P | 2,88 | 2,95 | 2,82 | 3,41 | 0,032 | 0,09 | 0,380 |
| G | 8,18 | 8,66 | 8,92 | 11,24 | 0,057 | 0,01 | 0,928 |

### Pareamento por número da repetição (2ª–10ª dos 3 termos): a versão com threads foi mais rápida?

| Campanha | Métrica | Algoritmo | Dataset | Com threads mais rápida | Com threads mais lenta | p (teste de sinais) | Mediana de sem ÷ com por par |
| --- | --- | --- | --- | :---: | :---: | ---: | ---: |
| 2026-10-25_172153 | processamento | Linear | P | 0/27 | 27/27 | < 0,001 | 0,096 |
| 2026-10-25_172153 | processamento | Linear | G | 1/27 | 26/27 | < 0,001 | 0,25 |
| 2026-10-25_172153 | processamento | Binária | P | 8/27 | 19/27 | 0,052 | 0,53 |
| 2026-10-25_172153 | processamento | Binária | G | 13/27 | 14/27 | 1,000 | 0,83 |
| 2026-10-25_172153 | total | Linear | P | 4/27 | 23/27 | < 0,001 | 0,76 |
| 2026-10-25_172153 | total | Linear | G | 3/27 | 24/27 | < 0,001 | 0,79 |
| 2026-10-25_172153 | total | Binária | P | 7/27 | 20/27 | 0,019 | 0,62 |
| 2026-10-25_172153 | total | Binária | G | 13/27 | 14/27 | 1,000 | 0,85 |
| 2026-10-25_172540 | processamento | Linear | P | 0/27 | 27/27 | < 0,001 | 0,12 |
| 2026-10-25_172540 | processamento | Linear | G | 3/27 | 24/27 | < 0,001 | 0,25 |
| 2026-10-25_172540 | processamento | Binária | P | 8/27 | 19/27 | 0,052 | 0,68 |
| 2026-10-25_172540 | processamento | Binária | G | 23/27 | 4/27 | < 0,001 | 2,18 |
| 2026-10-25_172540 | total | Linear | P | 8/27 | 19/27 | 0,052 | 0,84 |
| 2026-10-25_172540 | total | Linear | G | 6/27 | 21/27 | 0,006 | 0,85 |
| 2026-10-25_172540 | total | Binária | P | 8/27 | 19/27 | 0,052 | 0,77 |
| 2026-10-25_172540 | total | Binária | G | 23/27 | 4/27 | < 0,001 | 1,92 |

### Reprodutibilidade — fase de processamento

| Algoritmo | Dataset | Termo | Speedup [IC 95%] 2026-10-25_172153 | Speedup [IC 95%] 2026-10-25_172540 | p (Holm) replicação | Mesma direção? |
| --- | --- | --- | ---: | ---: | ---: | :---: |
| Linear | P | Kelly Fields | 0,006 (0,004 – 0,015) | 0,007 (0,002 – 0,026) | 0,003 | sim |
| Linear | P | Tyler Barrera | 0,50 (0,30 – 0,68) | 0,69 (0,22 – 0,85) | 0,025 | sim |
| Linear | P | Sara White | 0,086 (0,051 – 0,18) | 0,10 (0,033 – 0,52) | 0,008 | sim |
| Linear | G | Kelly Fields | 0,053 (0,019 – 0,13) | 0,032 (0,018 – 0,18) | 0,005 | sim |
| Linear | G | Tyler Barrera | 0,34 (0,096 – 1,12) | 0,91 (0,16 – 1,93) | 0,637 | sim |
| Linear | G | Sara White | 0,23 (0,078 – 0,69) | 0,26 (0,098 – 0,94) | 0,169 | sim |
| Binária | P | Kelly Fields | 0,52 (0,44 – 0,75) | 0,55 (0,48 – 0,74) | 0,169 | sim |
| Binária | P | Tyler Barrera | 0,55 (0,52 – 0,97) | 0,65 (0,45 – 1,29) | 0,637 | sim |
| Binária | P | Sara White | 0,61 (0,31 – 3,19) | 0,55 (0,22 – 2,43) | 0,637 | sim |
| Binária | G | Kelly Fields | 1,95 (0,49 – 2,74) | 3,72 (1,03 – 7,00) | 0,169 | sim |
| Binária | G | Tyler Barrera | 1,02 (0,48 – 1,58) | 2,05 (0,50 – 2,65) | 0,169 | sim |
| Binária | G | Sara White | 0,35 (0,19 – 0,48) | 2,33 (0,58 – 2,97) | 0,356 | **não** |

### Reprodutibilidade — tempo total

| Algoritmo | Dataset | Termo | Speedup [IC 95%] 2026-10-25_172153 | Speedup [IC 95%] 2026-10-25_172540 | p (Holm) replicação | Mesma direção? |
| --- | --- | --- | ---: | ---: | ---: | :---: |
| Linear | P | Kelly Fields | 0,70 (0,49 – 0,91) | 0,80 (0,51 – 1,07) | 0,712 | sim |
| Linear | P | Tyler Barrera | 0,91 (0,64 – 1,08) | 1,12 (0,57 – 1,36) | 1,000 | **não** |
| Linear | P | Sara White | 0,72 (0,60 – 0,91) | 0,80 (0,56 – 1,09) | 0,681 | sim |
| Linear | G | Kelly Fields | 0,81 (0,49 – 1,25) | 0,81 (0,58 – 1,20) | 1,000 | sim |
| Linear | G | Tyler Barrera | 0,73 (0,52 – 1,26) | 1,16 (0,62 – 1,66) | 1,000 | **não** |
| Linear | G | Sara White | 0,86 (0,48 – 1,44) | 0,84 (0,58 – 1,12) | 1,000 | sim |
| Binária | P | Kelly Fields | 0,60 (0,53 – 0,79) | 0,66 (0,60 – 0,81) | 0,452 | sim |
| Binária | P | Tyler Barrera | 0,64 (0,59 – 1,00) | 0,75 (0,56 – 1,28) | 1,000 | sim |
| Binária | P | Sara White | 0,61 (0,40 – 1,79) | 0,71 (0,33 – 1,78) | 1,000 | sim |
| Binária | G | Kelly Fields | 1,44 (0,51 – 2,15) | 3,61 (1,06 – 5,81) | 0,254 | sim |
| Binária | G | Tyler Barrera | 1,03 (0,49 – 1,51) | 1,75 (0,53 – 2,23) | 0,283 | sim |
| Binária | G | Sara White | 0,38 (0,19 – 0,55) | 1,93 (0,63 – 2,50) | 0,729 | **não** |

### Posição de cada termo nos datasets

| Dataset | Termo | Ocorrência (arquivo:linha) |
| --- | --- | --- |
| P | Kelly Fields | arq_1.txt:5 |
| P | Tyler Barrera | ausente |
| P | Sara White | arq_1.txt:1000 |
| G | Kelly Fields | a1.txt:1204 |
| G | Tyler Barrera | a5.txt:10000 |
| G | Sara White | a6.txt:2680 |
