package model;

import enums.TipoInvocacaoEnum;

public class User{
    private int id;
    private String nome;
    private int nivel;
    private TipoInvocacaoEnum invocacao;
    
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
    
    // get e set do nível
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    // get e set Tipo de Invocação
    public TipoInvocacaoEnum getInvocacao() {
        return invocacao;
    }
    public void setTipoInvocacao(TipoInvocacaoEnum invocacao){
        this.invocacao = invocacao;
    }
}