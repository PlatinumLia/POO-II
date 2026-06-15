import java.util.ArrayList;

public class CRUD_Generico {
    public static void main(String[] args) {
        DaoGenerico daoGen = new DaoGenerico();

        //teste inserir
        // Veiculo v = new Veiculo();
        // v.setAno(2020);
        // v.setModelo("Cobalt");
        // v.setMarca("Chevrolet");
        // v.setChassi("123qwe");
        // daoGen.inserir(v);

        //teste buscarTodos
        ArrayList<Veiculo> itens = daoGen.buscarTodos(Veiculo.class);
        for (Veiculo v : itens) {
            System.out.println("Veiculo: " + v.getModelo()
                + " - Marca: " + v.getMarca());
        }

    }
}
