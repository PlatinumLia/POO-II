import java.util.Scanner;

public class GerenciadorVendedor{
    Scanner scanner;
    DaoVendedor daoVendedor;

    public GerenciadorVendedor(){ //método construtor
        scanner = new Scanner(System.in);
        daoVendedor = new DaoVendedor();
    }

    public void menu(){
        int opc = -1;

        while(opc != 0){
            System.out.println("\n-----------------------------------");
            System.out.println("GERENCIAMENTO DE VENDEDORES\n");
            System.out.println("[1]. Cadastrar um novo vendedor");
            System.out.println("[2]. Consultar dados de um vendedor");
            System.out.println("[3]. Alterar dados de um vendedor");
            System.out.println("[4]. Excluir um vendedor");
            System.out.println("[5]. Listar todos os vendedores");
            System.out.println("[0]. Sair");
            System.out.println("\n-----------------------------------");

            try{
                opc = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                System.out.println("Informe um Nº inteiro");
            }

            switch(opc){
                case 1:
                    this.cadastrar();
                    break;
            }
        }
    }

    private void cadastrar(){
        
    }
}
