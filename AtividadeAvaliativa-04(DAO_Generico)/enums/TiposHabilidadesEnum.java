package enums;

public enum TiposHabilidadesEnum{
    PHYS("Physical"),
    GUN("Gun"),
    FIRE("Fire"),
    ICE("Ice"),
    ELEC("Electric"),
    WIND("Wind"),
    PSY("Psychokinesis"),
    NUKE("Nuclear"),
    BLESS("Bless"),
    CURSE("Curse"),
    ALMIGHTY("Almigthy");

    String habilidade;

    TiposHabilidadesEnum(String habilidade){
        this.habilidade = habilidade;
    }

    public String getHabilidade(){
        return this.habilidade;
    }
}