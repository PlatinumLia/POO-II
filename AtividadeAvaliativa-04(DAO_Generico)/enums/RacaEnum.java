package enums;

public enum RacaEnum{
    AKUMA(1 , "Akuma"),
    BEAST(2, "Beast"),
    BRUTE(3, "Brute"),
    DEITY(4, "Deity"),
    DEVIL(5, "Devil"),
    DIVINE(6, "Divine"),
    DRAGON(7, "Dragon"),
    FAIRY(8, "Fairy"),
    FEMME(9, "Femme"),
    FIEND(10, "Fiend"),
    LADY(11, "Lady"),
    MEGAMI(12, "Megami"),
    MITAMA(13, "Mitama"),
    TYRANT(14, "Tryrant"),
    WARGOD(15, "Wargod"),
    YOMA(16, "Yoma"),
    ZEALOT(17, "Zealot");

    private String raca;
    private int identificador;

    RacaEnum(int identificador, String raca){
        this.raca = raca;
        this.identificador = identificador;
    }

    public String getRaca(){
        return this.raca;
    }

    public int getIdentificador(){
        return this.identificador;
    }

    public static RacaEnum fromIdentificador(int identificador){
        for(RacaEnum r : values()){
            if(r.getIdentificador() == identificador){
                return r;
            }
        }
        throw new IllegalArgumentException("Raça não listada.");
    }
}
