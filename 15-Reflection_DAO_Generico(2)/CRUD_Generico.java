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
        // ArrayList<Veiculo> itens = daoGen.buscarTodos(Veiculo.class);
        // for (Veiculo v : itens) {
        //     System.out.println("Veiculo: " + v.getModelo()
        //         + " - Marca: " + v.getMarca());
        // }

        //Teste buscartodos filtro
        // ArrayList<Veiculo> itens = daoGen.buscarTodosFiltro(
        //     Veiculo.class, "marca", "Fiat");
        // for (Veiculo v : itens) {
        //     System.out.println("Veiculo: " + v.getModelo()
        //         + " - marca: " + v.getMarca());
        // }     

        //Teste excluir
        // int qtde = daoGen.excluir(Veiculo.class, "codigo", 9);
        // System.out.println("Qtde excluída: " + qtde);

        //Teste consultar
        // Veiculo v = daoGen.consultar(Veiculo.class, "codigo", "8");
        // if(v != null){
        //     System.out.println("O veiculo é: " + v.getModelo());
        // }else{
        //     System.out.println("Não encontrado");
        // }

        //Teste alterar
        Veiculo v = new Veiculo();
        v.setAno(2026);
        v.setModelo("ARGOOOO!!!!!");
        v.setMarca("FIAT");
        v.setChassi("aaa111");
        int qtdeAlterado = daoGen.alterar(v, "codigo", "8");
        System.out.println("Registros atualizados: " + qtdeAlterado);
    }
}
