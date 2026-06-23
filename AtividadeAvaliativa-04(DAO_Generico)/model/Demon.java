import enums.RacaEnum;
import enums.TiposHabilidadesEnum;

public class Demon {
    private Integer id;
    private String nome;
    private int nivel;
    private RacaEnum raca;
    private TiposHabilidadesEnum fraqueza;
    
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
    
    // get e set Nível
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    // get e set Raça
    public RacaEnum getRaca() {
        return raca;
    }
    public void setRaca(RacaEnum raca) {
        this.raca = raca;
    }
    
    // get e set fraqueza
    public TiposHabilidadesEnum getFraqueza() {
        return fraqueza;
    }
    public void setFraqueza(TiposHabilidadesEnum fraqueza) {
        this.fraqueza = fraqueza;
    }   
}