public class Locadora{
    public static void main(String[] args) {
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        Veiculo vei = new Veiculo();
        
        vei.setMarca("Mitsubushi");
        vei.setModelo("Eclipse 1G");
        vei.setChassi("sdfsfw342sfs1");
        vei.setAno(1989);

        boolean inserido = daoVeiculo.inserir(vei);
        System.out.println("Inserido? " + inserido);
    }
}
