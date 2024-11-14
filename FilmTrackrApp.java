import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FilmTrackrApp extends JFrame {
    private ArrayList<FilmTrackr> filmes = new ArrayList<>();
    private JTextArea displayArea;

    public FilmTrackrApp() {
        setTitle("FilmTrackr");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton addButton = new JButton("Adicionar Filme");
        JButton updateButton = new JButton("Alterar Filme");
        JButton deleteButton = new JButton("Excluir Filme");
        JButton viewButton = new JButton("Consultar Filme");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFilm();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFilm();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFilm();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewFilm();
            }
        });

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(viewButton);
        panel.add(scrollPane);

        add(panel);
    }

    private void addFilm() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Filme:"));
        String titulo = JOptionPane.showInputDialog("Título do Filme:");
        String diretor = JOptionPane.showInputDialog("Diretor do Filme:");
        int anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Ano de Lançamento:"));
        String genero = JOptionPane.showInputDialog("Gênero do Filme:");
        double duracao = Double.parseDouble(JOptionPane.showInputDialog("Duração (em horas):"));
        String idioma = JOptionPane.showInputDialog("Idioma:");
        String paisOrigem = JOptionPane.showInputDialog("País de Origem:");
        boolean assistido = JOptionPane.showConfirmDialog(this, "Já assistiu?") == JOptionPane.YES_OPTION;
        double avaliacao = Double.parseDouble(JOptionPane.showInputDialog("Avaliação (0 a 10):"));
    
        FilmTrackr novoFilme = new FilmTrackr(id, titulo, diretor, anoLancamento, genero, duracao, idioma, paisOrigem, assistido, avaliacao);
        filmes.add(novoFilme);
        JOptionPane.showMessageDialog(this, "Filme adicionado com sucesso!");
        updateDisplayArea(); 
    }
    
    private void updateFilm() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Filme para alterar:"));
        FilmTrackr filmeParaAlterar = null;
    
        for (FilmTrackr filme : filmes) {
            if (filme.getId() == id) {
                filmeParaAlterar = filme;
                break;
            }
        }
    
        if (filmeParaAlterar != null) {
            filmeParaAlterar.setTitulo(JOptionPane.showInputDialog("Novo Título:", filmeParaAlterar.getTitulo()));
            filmeParaAlterar.setDiretor(JOptionPane.showInputDialog("Novo Diretor:", filmeParaAlterar.getDiretor()));
            filmeParaAlterar.setAnoLancamento(Integer.parseInt(JOptionPane.showInputDialog("Novo Ano de Lançamento:", filmeParaAlterar.getAnoLancamento())));
            filmeParaAlterar.setGenero(JOptionPane.showInputDialog("Novo Gênero:", filmeParaAlterar.getGenero()));
            filmeParaAlterar.setDuracao(Double.parseDouble(JOptionPane.showInputDialog("Nova Duração:", filmeParaAlterar.getDuracao())));
            filmeParaAlterar.setIdioma(JOptionPane.showInputDialog("Novo Idioma:", filmeParaAlterar.getIdioma()));
            filmeParaAlterar.setPaisOrigem(JOptionPane.showInputDialog("Novo País de Origem:", filmeParaAlterar.getPaisOrigem()));
            filmeParaAlterar.setAssistido(JOptionPane.showConfirmDialog(this, "Já assistiu?") == JOptionPane.YES_OPTION);
            filmeParaAlterar.setAvaliacao(Double.parseDouble(JOptionPane.showInputDialog("Nova Avaliação:", filmeParaAlterar.getAvaliacao())));
            JOptionPane.showMessageDialog(this, "Filme alterado com sucesso!");
            updateDisplayArea();  
        } else {
            JOptionPane.showMessageDialog(this, "Filme não encontrado!");
        }
    }
    
    private void updateDisplayArea() {
        displayArea.setText("");  
        for (FilmTrackr filme : filmes) {
            displayArea.append(filme.toString() + "\n\n"); 
        }
    }

    private void deleteFilm() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Filme para excluir:"));
            FilmTrackr filmeParaExcluir = null;

            for (FilmTrackr filme : filmes) {
                if (filme.getId() == id) {
                    filmeParaExcluir = filme;
                    break;
                }
            }

            if (filmeParaExcluir != null) {
                filmes.remove(filmeParaExcluir);
                JOptionPane.showMessageDialog(this, "Filme excluído com sucesso!");
                updateDisplayArea();  
            } else {
                JOptionPane.showMessageDialog(this, "Filme não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID inválido!");
        }
    }

    private void viewFilm() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Filme para consultar:"));
            FilmTrackr filmeParaConsultar = null;

            for (FilmTrackr filme : filmes) {
                if (filme.getId() == id) {
                    filmeParaConsultar = filme;
                    break;
                }
            }

            if (filmeParaConsultar != null) {
                JOptionPane.showMessageDialog(null, filmeParaConsultar.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Filme não encontrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o filme.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FilmTrackrApp().setVisible(true);
            }
        });
    }
}
