public enum LivroEnum{
    A_METAMORFOSE("A Metamorfose", 1995, "Franz Kafka", 96, "Novela"),
    VERITY("Verity", 2018, "Colleen Hoover", 324, "Romance");

    private String titulo, autor, generoLiterario;
    private int anoLancamento, qtdPaginas;

    LivroEnum(String titulo, int ano, String autor, int paginas, String genero){
        this.titulo = titulo;
        this.anoLancamento = ano;
        this.autor = autor;
        this.qtdPaginas = paginas;
        this.generoLiterario = genero;
    }

    /* métodos get */
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getGeneroLiterario() {
        return this.generoLiterario;
    }

    public int getAnoLancamento() {
        return this.anoLancamento;
    }

    public int getQtdPaginas() {
        return this.qtdPaginas;
    }   
}