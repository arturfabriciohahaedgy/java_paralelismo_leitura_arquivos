package view;

import utils.Line;
import utils.SearchUtils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JRadioButton smallDataset = new JRadioButton("P", true);
    private final JRadioButton largeDataset = new JRadioButton("G");
    private final JTextField queryField = new JTextField();
    private final JButton searchButton = new JButton("PESQUISAR");
    private final JButton clearButton = new JButton("LIMPAR");
    private final DefaultTableModel results = new DefaultTableModel(
            new String[] { "Arquivo", "Linha", "Texto da linha" }, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JLabel timeLabel = new JLabel("Tempo da pesquisa: -");
    private SwingWorker<Long, Object[]> searchWorker;

    public MainWindow() {
        super("Pesquisa nos datasets - com paralelismo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel content = new JPanel(new BorderLayout(0, 20));
        content.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
        setContentPane(content);

        JPanel controls = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 0, 10, 0);
        controls.add(new JLabel("Dataset"), constraints);

        JPanel datasets = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        smallDataset.setToolTipText("Dataset pequeno: arq_*.txt");
        largeDataset.setToolTipText("Dataset grande: a*.txt");
        ButtonGroup datasetGroup = new ButtonGroup();
        datasetGroup.add(smallDataset);
        datasetGroup.add(largeDataset);
        datasets.add(smallDataset);
        datasets.add(Box.createHorizontalStrut(40));
        datasets.add(largeDataset);
        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 24, 0);
        controls.add(datasets, constraints);

        constraints.gridy++;
        constraints.insets = new Insets(0, 0, 8, 0);
        controls.add(new JLabel("Insira um dado para pesquisa:"), constraints);
        constraints.gridy++;
        queryField.setPreferredSize(new Dimension(500, 32));
        controls.add(queryField, constraints);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 16, 0));
        searchButton.setPreferredSize(new Dimension(160, 40));
        clearButton.setPreferredSize(new Dimension(160, 40));
        actions.add(searchButton);
        actions.add(clearButton);
        constraints.gridy++;
        constraints.insets = new Insets(10, 0, 0, 0);
        controls.add(actions, constraints);
        content.add(controls, BorderLayout.NORTH);

        JTable table = new JTable(results);
        table.setRowHeight(30);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(540);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        content.add(scroll, BorderLayout.CENTER);

        // Rodapé: tempo à esquerda e modo de execução à direita
        JLabel modeLabel = new JLabel("PARALELISMO COM BUSCA BINÁRIA");
        modeLabel.setFont(modeLabel.getFont().deriveFont(Font.BOLD));
        modeLabel.setForeground(Color.BLUE);
        JPanel footer = new JPanel(new BorderLayout());
        footer.add(timeLabel, BorderLayout.WEST);
        footer.add(modeLabel, BorderLayout.EAST);
        content.add(footer, BorderLayout.SOUTH);

        searchButton.addActionListener(event -> search());
        queryField.addActionListener(event -> {
            if (searchButton.isEnabled()) {
                search();
            }
        });
        clearButton.addActionListener(event -> clear());
        getRootPane().setDefaultButton(searchButton);

        setSize(800, 600);
        setMinimumSize(new Dimension(550, 400));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void search() {
        String query = queryField.getText().trim();
        boolean small = smallDataset.isSelected();
        boolean large = largeDataset.isSelected();
        if (query.isEmpty() || (!small && !large)) {
            JOptionPane.showMessageDialog(this, "Selecione um dataset e informe o texto da pesquisa.");
            return;
        }

        results.setRowCount(0);
        searchButton.setEnabled(false);
        searchWorker = new SwingWorker<Long, Object[]>() {
            @Override
            protected Long doInBackground() throws IOException, InterruptedException {
                // Mede o tempo da pesquisa e devolve para o done()
                long start = System.nanoTime();
                List<Line> searchResult = SearchUtils.Search(small ? "./com_paralelismo_binary_search/datasets/p" : "./com_paralelismo_binary_search/datasets/g", query);
                for (Line line : searchResult) {
                    results.addRow(new String[]{line.file(), String.valueOf(Integer.parseInt(String.valueOf(line.line()))), line.name()});
                }
                long end = System.nanoTime();
                return end - start;
            }

            @Override
            protected void process(List<Object[]> rows) {
                if (searchWorker == this && !isCancelled()) {
                    for (Object[] row : rows) {
                        results.addRow(row);
                    }
                }
            }

            @Override
            protected void done() {
                if (searchWorker != this) {
                    return;
                }
                searchButton.setEnabled(true);
                try {
                    long elapsed = get();
                    timeLabel.setText(String.format("Tempo da pesquisa: %.2f ms", elapsed / 1_000_000.0));
                } catch (CancellationException ignored) {
                    // A pesquisa foi cancelada pelo botão Limpar.
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException exception) {
                    System.out.println(exception.toString());
                    JOptionPane.showMessageDialog(MainWindow.this,
                            "Não foi possível pesquisar: " + exception.getCause().getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        searchWorker.execute();
    }

    private void clear() {
        if (searchWorker != null) {
            searchWorker.cancel(true);
            searchWorker = null;
        }
        searchButton.setEnabled(true);
        queryField.setText("");
        results.setRowCount(0);
        timeLabel.setText("Tempo da pesquisa: -");
        queryField.requestFocusInWindow();
    }
}
