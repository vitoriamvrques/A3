import javax.swing.JOptionPane;
import java.util.ArrayList;

public class FilmTrackr {
    private int id;
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;
    private double duracao;
    private String idioma;
    private String paisOrigem;
    private boolean assistido;
    private double avaliacao;

    public FilmTrackr() {}

    public FilmTrackr(int id, String titulo, String diretor, int anoLancamento, String genero, double duracao, String idioma, String paisOrigem, boolean assistido, double avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
        this.duracao = duracao;
        this.idioma = idioma;
        this.paisOrigem = paisOrigem;
        this.assistido = assistido;
        this.avaliacao = avaliacao;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDiretor() { return diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }

    public int getAnoLancamento() { return anoLancamento; }
    public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public double getDuracao() { return duracao; }
    public void setDuracao(double duracao) { this.duracao = duracao; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public String getPaisOrigem() { return paisOrigem; }
    public void setPaisOrigem(String paisOrigem) { this.paisOrigem = paisOrigem; }

    public boolean isAssistido() { return assistido; }
    public void setAssistido(boolean assistido) { this.assistido = assistido; }

    public double getAvaliacao() { return avaliacao; }
    public void setAvaliacao(double avaliacao) { this.avaliacao = avaliacao; }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nTítulo: " + titulo +
                "\nDiretor: " + diretor +
                "\nAno de Lançamento: " + anoLancamento +
                "\nGênero: " + genero +
                "\nDuração: " + duracao + " horas" +
                "\nIdioma: " + idioma +
                "\nPaís de Origem: " + paisOrigem +
                "\nAssistido: " + (assistido ? "Sim" : "Não") +
                "\nAvaliação: " + avaliacao;
    }

    public static void main(String[] args) {
        ArrayList<FilmTrackr> filmes = new ArrayList<>();
        int opcao;

        do {
            String menu = "1 - Adicionar Filme\n2 - Alterar Filme\n3 - Excluir Filme\n4 - Consultar Filme\n5 - Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do Filme:"));
                    String titulo = JOptionPane.showInputDialog("Título do Filme:");
                    String diretor = JOptionPane.showInputDialog("Diretor do Filme:");
                    int anoLancamento = Integer.parseInt(JOptionPane.showInputDialog("Ano de Lançamento:"));
                    String genero = JOptionPane.showInputDialog("Gênero do Filme:");
                    double duracao = Double.parseDouble(JOptionPane.showInputDialog("Duração (em horas):"));
                    String idioma = JOptionPane.showInputDialog("Idioma:");
                    String paisOrigem = JOptionPane.showInputDialog("País de Origem:");
                    boolean assistido = JOptionPane.showConfirmDialog(null, "Já assistiu?") == JOptionPane.YES_OPTION;
                    double avaliacao = Double.parseDouble(JOptionPane.showInputDialog("Avaliação (0 a 10):"));

                    FilmTrackr novoFilme = new FilmTrackr(id, titulo, diretor, anoLancamento, genero, duracao, idioma, paisOrigem, assistido, avaliacao);
                    filmes.add(novoFilme);
                    JOptionPane.showMessageDialog(null, "Filme adicionado com sucesso!");
                    break;

                case 2:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Filme para alterar:"));
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
                        filmeParaAlterar.setAssistido(JOptionPane.showConfirmDialog(null, "Já assistiu?") == JOptionPane.YES_OPTION);
                        filmeParaAlterar.setAvaliacao(Double.parseDouble(JOptionPane.showInputDialog("Nova Avaliação:", filmeParaAlterar.getAvaliacao())));
                        JOptionPane.showMessageDialog(null, "Filme alterado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Filme não encontrado!");
                    }
                    break;

                case 3:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Filme para excluir:"));
                    FilmTrackr filmeParaExcluir = null;

                    for (FilmTrackr filme : filmes) {
                        if (filme.getId() == id) {
                            filmeParaExcluir = filme;
                            break;
                        }
                    }

                    if (filmeParaExcluir != null) {
                        filmes.remove(filmeParaExcluir);
                        JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Filme não encontrado!");
                    }
                    break;

                case 4:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Filme para consultar:"));
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
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }
}
