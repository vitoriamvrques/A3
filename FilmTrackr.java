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
}

