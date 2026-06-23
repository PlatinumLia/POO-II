package enums;

public enum TipoInvocacaoEnum{
    EVOKER("Evoker"),
    MASK("Máscara"),
    CARD("Carta"),
    RECRUIT("Recrutar");

    String invocacao;

    TipoInvocacaoEnum(String invocacao){
        this.invocacao = invocacao;
    }

    public String getInvocacao(){
        return this.invocacao;
    }
}