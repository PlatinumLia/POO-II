import java.util.HashMap;

public class CadEstado{
    public static void main(String[] args) {
        HashMap<String, Estado> estados = new HashMap<String, Estado>();

        Estado e1 = new Estado();
        e1.setNome("Paraná");
        e1.setRegiao("Sul");
        estados.put("PR", e1);

        Estado e2 = new Estado();
        e2.setNome("Bahia");
        e2.setRegiao("Nordeste");
        estados.put("BA", e2);

        Estado e3 = new Estado();
        e3.setNome("São Paulo");
        e3.setRegiao("Sudeste");
        estados.put("SP", e3);

        System.out.println("Estados: " + estados);

        System.out.println("");
        System.out.println("Verificando se um estado existe no hashmap");
        String pesquisado = "SP";
        if(estados.containsKey(pesquisado)){
            System.out.println(pesquisado + "existe no hashmap");
            
            System.out.println("");
            System.out.println("Buscando a região do estado de " + pesquisado);
            System.out.println("Região: " + estados.get(pesquisado).getRegiao());
        }else{
            System.out.println("Não encontrado");
        }

        System.out.println("");
        System.out.println("Percorrendo as chaves");
        for(String item : estados.keySet()){
            System.out.println(item);
        }

        System.out.println("");
        System.out.println("Percorrendo os valores");
        for(Estado e : estados.values()){
            System.out.println(e.getNome() + " - região: " + e.getRegiao());
        }


    }
}