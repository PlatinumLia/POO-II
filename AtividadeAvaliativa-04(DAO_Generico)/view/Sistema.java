package view;

import java.util.Scanner;

public class Sistema{
    public static Sistema sis;
    public static void main(String[] args){
        sis = new Sistema();
        sis.menu();
    }

    private void menu(){
         /* Try-with-resources: Quando esse bloco encerrar o scanner, 
            encerra liberando seu espaço na memoria
        */
        try(Scanner scanner = new Scanner(System.in)){
            int opc = -1;
            
            while(opc < 0 || opc > 2){
                System.out.println("\n==========SISTEMA==========");
                System.out.println("\n----------MENU----------");
                System.out.println("[1]. Menu Demon.");
                System.out.println("[2]. Menu User.");
                System.out.println("[0] Sair");
                System.out.println("------------------------");

                try{
                    System.out.print("Escolha uma opção: ");
                    opc = Integer.parseInt(scanner.nextLine());
                }catch(Exception e){
                    System.out.println("ERRO: Informe um valor valido!");
                }

                switch (opc) {
                    case 1:
                        DemonView dv = new DemonView();
                        dv.exibirMenu();
                        break;

                    case 2:
                        UserView uv = new UserView();
                        uv.exibirMenu();
                        break;

                    case 0:
                        System.out.println("SAINDO...");
                        break;

                    default:
                        System.out.println("ERRO: Opção invalida!");
                        break;
                }
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
