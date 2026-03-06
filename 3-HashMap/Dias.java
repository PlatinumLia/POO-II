import java.util.HashMap;

public class Dias{
    public static void main(String[] args) {
        //criando o HashMap
        HashMap<String, String> diasSemana = new HashMap<String, String>();

        //colocando os itens no Hash
        diasSemana.put("Dom", "Domingo");
        diasSemana.put("Seg", "Segunda-feira");
        diasSemana.put("Ter", "Terça-feira");
        diasSemana.put("Qua", "Quarta-feira");
        diasSemana.put("Qui", "Quinta-feira");
        diasSemana.put("Sex", "Sexta-feira");
        diasSemana.put("Sab", "Sábado-feira");

        //sobrescrevendo um item
        diasSemana.put("Sab", "Sabadão!");
        
        System.out.println("");
        System.out.println("Mostrando os pares armazenados:");
        System.out.println(diasSemana);

        System.out.println("");
        System.out.println("Verificando se um dia existe");
        System.out.println("Qua existe?" + diasSemana.containsKey("Qua"));
        System.out.println("Aaa existe?" + diasSemana.containsKey("A"));
        
        System.out.println("");
        System.out.println("Pegando um item a partir da chave");
        System.out.println("O valor da chave 'Ter' é: " + diasSemana.get("Ter"));

        System.out.println("");
        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size());
        
        //removendo um item
        System.out.println("");
        String itemRemover = "Sex";
        System.out.println("Removendo o item: " + itemRemover);
        diasSemana.remove(itemRemover);
        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size());

        System.out.println("");
        System.out.println("Chaves:");
        //precorrendo as chaves
        for(String item : diasSemana.keySet()){ //usando foreach para percorrer
            System.out.println(item);
        }

        System.out.println("");
        System.out.println("Valores:");
        //percorrendo os valores
        for(String item : diasSemana.values()){
            System.out.println(item);
        }

        System.out.println("");
        System.out.println("Removendo todas as chaves");
        diasSemana.clear();
        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size());

    }
}