package enums;

public enum TipoInvocacaoEnum{
    EVOKER(1, "Evoker"),
    MASK(2, "Máscara"),
    CARD(3, "Carta"),
    RECRUIT(4, "Recrutar");

    int identificador;
    String invocacao;

    TipoInvocacaoEnum(int identificador, String invocacao){
        this.invocacao = invocacao;
        this.identificador = identificador;
    }
    
    public int getIdentificador(){
        return identificador;
    }

    public String getInvocacaoNome(){
        return invocacao;
    }

    public static TipoInvocacaoEnum fromIdentificador(int identificador){
        for(TipoInvocacaoEnum ti : values()){
            if(ti.getIdentificador() == identificador){
                return ti;
            }
        }
        throw new IllegalArgumentException("Invocação não listada.");
    }
}