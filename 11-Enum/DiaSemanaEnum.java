public enum DiaSemanaEnum{
    //definindo os enums com um valor associado
    SEG("Segunda-feira"),
    TER("Terça-feira"),
    QUA("Quarta-feira"),
    QUI("Quinta-feira"),
    SEX("Sexta-feira"),
    SAB("Sábado"),
    DOM("Domingo");

    private String dia;

    DiaSemanaEnum(String nomeDia){ //método construtor
        this.dia = nomeDia;
    }

    public String getDia(){
        return this.dia;
    }
}