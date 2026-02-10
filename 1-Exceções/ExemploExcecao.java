public class ExemploExcecao{
    public static void main(String[] args) {
        ExemploExcecao ee = new ExemploExcecao();
        ee.calcular();
    }

    public void calcular(){
        try{
            OperacoesMatematicas opMat = new OperacoesMatematicas();
            //testando os resultados e a exceção
            float res = opMat.dividir(12, 3);
            System.out.println(res);
            res = opMat.dividir(12, 0);
            System.out.println(res);
        }catch(DivisaoPorZeroException e){
            System.out.println(e.getMessage());
        }
    }
}