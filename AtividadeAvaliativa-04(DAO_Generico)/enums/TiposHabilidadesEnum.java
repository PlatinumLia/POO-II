package enums;

public enum TiposHabilidadesEnum{
    PHYS(1, "Physical"),
    GUN(2, "Gun"),
    FIRE(3, "Fire"),
    ICE(4, "Ice"),
    ELEC(5, "Electric"),
    WIND(6, "Wind"),
    PSY(7, "Psychokinesis"),
    NUKE(8, "Nuclear"),
    BLESS(9, "Bless"),
    CURSE(10, "Curse"),
    ALMIGHTY(11, "Almigthy");

    int identificador;
    String habilidade;

    TiposHabilidadesEnum(int identificador, String habilidade){
        this.identificador = identificador;
        this.habilidade = habilidade;
    }

    public int getIdentificador(){
        return identificador;
    }

    public String getHabilidade(){
        return habilidade;
    }

    public static TiposHabilidadesEnum fromIdentificador(int identificador){
        for(TiposHabilidadesEnum th : values()){
            if(th.getIdentificador() == identificador){
                return th;
            }
        }
        throw new IllegalArgumentException("Habilidade não listada.");
    }
}