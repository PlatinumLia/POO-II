public class Aeroporto{
    private String nome;
    private String cidade;
    private Double altitude;
    
    /* Getter e Setters */
    //get e set do nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //get e set da cidade
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    //get e set da altitude
    public Double getAltitude() {
        return altitude;
    }
    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }   
}