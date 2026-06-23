import enums.TipoInvocacaoEnum;

public class DemonUser{
    private Integer id;
    private String nome;
    private TipoInvocacaoEnum tipoInvocacao;
    private Demon demon;
    
    /* Métodos Getters e Setters */
    // get e set ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // get e set Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // get e set Tipo de Invocação
    public TipoInvocacaoEnum getTipoInvocacao() {
        return tipoInvocacao;
    }
    public void setTipoInvocacao(TipoInvocacaoEnum tipoInvocacao) {
        this.tipoInvocacao = tipoInvocacao;
    }

    // get e set Demon
    public Demon getDemon() {
        return demon;
    }
    public void setDemon(Demon demon) {
        this.demon = demon;
    }   
}