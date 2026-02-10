public class DivisaoPorZeroException extends Exception{
    //criar a própria exceção
    //herda a classe "Exception"

    public DivisaoPorZeroException(){
        super("Impossível dividir por 0.");
    }

}
