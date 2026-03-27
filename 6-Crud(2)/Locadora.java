import java.util.Scanner;

public class Locadora{
    public static void main(String[] args) {
        Locadora loc = new Locadora();
        loc.menuPrincipal();
    }

    private void menuPrincipal(){
        int opcao = -1;
        //try-with-resources: fecha o scanner ao final do bloco
        try(Scanner scanner = new Scanner(System.in)){
            while(opcao != 0){
                System.out.println("\n--------------------------------------");
                System.out.println("Menu");
                System.out.println("[1]. Gerenciar veículo");
                System.out.println("[2]. Gerenciar vendedores");
                System.out.println("[0]. Sair");
                System.out.println("\n--------------------------------------");

                try{
                    opcao = Integer.parseInt(scanner.nextLine());
                }catch(Exception e){
                    System.out.println("Informe um Nº válido.");
                }

                switch(opcao){
                    case 1:
                        GerenciadorVeiculo gv = new GerenciadorVeiculo();
                        gv.menu();
                        break;

                    case 2:
                        // vendedor
                        break;
                
                    case 0:
                        System.out.println("");
                        System.out.println("SAINDO...");
                        System.out.println("");
                        break;
                        
                    default:
                        System.out.println("");
                        System.out.println("Opção inválida.");
                        System.out.println("");
                        break;
                }
            }
        }

    }
}
