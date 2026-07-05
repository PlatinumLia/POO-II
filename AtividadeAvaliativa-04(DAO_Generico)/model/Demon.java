package model;

import enums.RacaEnum;
import enums.TiposHabilidadesEnum;

public class Demon {
    private int id;
    private String nome;
    private int nivel;
    private TiposHabilidadesEnum fraqueza;
    private RacaEnum raca;
    
    /* Métodos Getters e Setters */
    // get e set ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // get e set Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // get e set Nível
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    // get e set fraqueza
    public TiposHabilidadesEnum getFraqueza() {
        return fraqueza;
    }
    public void setFraqueza(TiposHabilidadesEnum fraqueza) {
        this.fraqueza = fraqueza;
    }

    // get e set raça
    public RacaEnum getRaca() {
        return raca;
    }
    public void setRaca(RacaEnum raca) {
        this.raca = raca;
    }
}