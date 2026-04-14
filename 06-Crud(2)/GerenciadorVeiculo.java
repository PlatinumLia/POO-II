import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculo{ //conterá métodos específicos do veículo
    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo(){ //método construtor
        scanner = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }

    public void menu(){
        int opcao = -1;

        while(opcao != 0){
            System.out.println("\n-----------------------------------");
            System.out.println("Gerenciamento de veículos");
            System.out.println("[1]. Cadastrar");
            System.out.println("[2]. Consultar");
            System.out.println("[3]. Alterar");
            System.out.println("[4]. Excluir");
            System.out.println("[5]. Listar todos");
            System.out.println("[0]. Sair");
            System.out.println("\n-----------------------------------");

            try{
                opcao = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                System.out.println("Informe um Nº inteiro");
            }

            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
            
                case 2:
                    // this.consultar();
                    break;

                case 3:
                    // this.alterar();
                    break;
                
                case 4:
                    this.excluir();
                    break;

                case 5:
                    this.listarTodos();
                    break;

                case 0:
                    System.out.println("");
                    System.out.println("SAINDO...");
                    System.out.println("");
                    break;

                default:
                    System.out.println("opção inválida.");
                    break;
            }
        }
    }

    private void cadastrar(){
        //instanciar objeto
        Veiculo vei = new Veiculo();

        System.out.println("\n---------------------------");
        System.out.println("CADASTRO DE VEÍCULO");
        System.out.println("---------------------------\n");

        //popular com dados informados pelo usuário
        System.out.println("Marca:");
        vei.setMarca(scanner.nextLine());
        System.out.println("Modelo:");
        vei.setModelo(scanner.nextLine());
        System.out.println("Chassi:");
        vei.setChassi(scanner.nextLine());
        System.out.println("Ano:");
        vei.setAno(Integer.parseInt(scanner.nextLine()));

        //inserir no banco e dar msg ao usuário
        boolean inserido = daoVeiculo.inserir(vei);
        if(inserido){
            System.out.println("Inserido com sucesso.");
        }
    }

    private void excluir(){
        int cod;
        int qtde = 0;

        System.out.println("");
        System.out.println("--EXCLUSÃO DE VEÍCULOS ---");
        System.out.println("");
        try{
            System.out.println("Código do veículo que deseja excluir:");
            cod = Integer.parseInt(scanner.nextLine());

            qtde = daoVeiculo.excluir(cod);
            if(qtde > 0){
                System.out.println("Excluído com sucesso!");
            }else{
                System.out.println("Não encontrado.");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

    }

    private void listarTodos(){
        ArrayList<Veiculo> veiculos = daoVeiculo.listarTodos();

        System.out.println("");
        for(Veiculo vei : veiculos){
            System.out.println("Código: " + vei.getCodigo() + "; Marca: " + vei.getMarca() + "; Modelo: " + vei.getModelo() + "; Chassi: " + vei.getChassi() + "; Ano: " + vei.getAno());
        }
        System.out.println("");
    }
}