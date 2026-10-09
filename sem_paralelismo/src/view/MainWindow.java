package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

public final class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private final JCheckBox smallDataset = new JCheckBox("P", true);
    private final JCheckBox largeDataset = new JCheckBox("G");
    private final JTextField queryField = new JTextField();
    private final JButton searchButton = new JButton("PESQUISAR");
    private final JButton clearButton = new JButton("LIMPAR");
    private final DefaultTableModel results = new DefaultTableModel(
            new String[] { "Arquivo:linha", "Texto da linha" }, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private SwingWorker<Void, Object[]> searchWorker;

    public MainWindow() {
        super("Pesquisa nos datasets");
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
        datasets.add(smallDataset);
        datasets.add(javax.swing.Box.createHorizontalStrut(40));
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
        table.getColumnModel().getColumn(1).setPreferredWidth(540);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        content.add(scroll, BorderLayout.CENTER);

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
        String query = queryField.getText().trim().toLowerCase(Locale.ROOT);
        boolean small = smallDataset.isSelected();
        boolean large = largeDataset.isSelected();
        if (query.isEmpty() || (!small && !large)) {
            JOptionPane.showMessageDialog(this, "Selecione um dataset e informe o texto da pesquisa.");
            return;
        }

        results.setRowCount(0);
        searchButton.setEnabled(false);
        searchWorker = new SwingWorker<Void, Object[]>() {
            @Override
            protected Void doInBackground() throws IOException {
                Path directory = Paths.get("sem_paralelismo", "dataset");
                if (!Files.isDirectory(directory)) {
                    directory = Paths.get("dataset");
                }
                List<Path> files;
                try (Stream<Path> paths = Files.list(directory)) {
                    files = paths.filter(Files::isRegularFile).filter(path -> {
                        String name = path.getFileName().toString();
                        return (small && name.matches("arq_\\d+\\.txt"))
                                || (large && name.matches("a\\d+\\.txt"));
                    }).sorted().collect(Collectors.toList());
                }
                for (Path file : files) {
                    if (isCancelled()) {
                        break;
                    }
                    try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
                        String line;
                        int lineNumber = 0;
                        while (!isCancelled() && (line = reader.readLine()) != null) {
                            lineNumber++;
                            if (line.toLowerCase(Locale.ROOT).contains(query)) {
                                publish(new Object[] { file.getFileName() + ":" + lineNumber, line });
                            }
                        }
                    }
                }
                return null;
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
                    get();
                } catch (CancellationException ignored) {
                    // A pesquisa foi cancelada pelo botão Limpar.
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException exception) {
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
        queryField.requestFocusInWindow();
    }
}
