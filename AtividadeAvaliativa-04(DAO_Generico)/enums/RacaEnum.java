package enums;

public enum RacaEnum{
    AKUMA("Akuma"),
    AMATSU("Amatsu"),
    BEAST("Beast"),
    BRUTE("Brute"),
    DEITY("Deity"),
    DEVIL("Devil"),
    DIVINE("Divine"),
    DRAGON("Dragon"),
    FAIRY("Fairy"),
    FEMME("Femme"),
    FIEND("Fiend"),
    LADY("Lady"),
    MEGAMI("Megami"),
    MITAMA("Mitama"),
    NIGHT("Night"),
    PRIMAL("Primal"),
    REAPER("Reaper"),
    SNAKE("Snake"),
    SPIRIT("Spirit"),
    TYRANT("Tryrant"),
    WARGOD("Wargod"),
    YOMA("Yoma"),
    ZEALOT("Zealot");

    private String raca;

    RacaEnum(String raca){
        this.raca = raca;
    }

    public String getRaca(){
        return this.raca;
    }
}
