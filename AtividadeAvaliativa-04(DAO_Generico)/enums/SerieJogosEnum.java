package enums;

public enum SerieJogosEnum{
    SMT(1, "Shin Megami Tensei"),
    PERSONA(2, "Persona"),
    DS(3, "Devil Survivors"),
    DDS(4, "Digital Devil Saga"),
    DSM(5, "Devil Summoner");

    private int identificador;
    private String serieJogo; 

    SerieJogosEnum(int identificador, String serieJogo){
        this.identificador = identificador;
        this.serieJogo = serieJogo;
    }

    public int getIdentificador(){
        return identificador;
    }

    public String getSerieJogo(){
        return serieJogo;
    }

    public static SerieJogosEnum fromIdentificador(int identificador){
        for(SerieJogosEnum sj : values()){
            if(sj.getIdentificador() == identificador){
                return sj;
            }
        }
        throw new IllegalArgumentException("Série-Jogo não listado.");
    }
}