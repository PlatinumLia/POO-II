package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.GenericDao;
import model.User;

public class UserView {
    private Scanner scanner;
    private GenericDao genericDao;
    
    public UserView(){
        scanner = new Scanner(System.in);
        genericDao = new GenericDao();
    }

    public void exibirMenu() throws Exception {
        try{
            int opc = -1;

            do {
                System.out.println("\n======= MENU USER =======");
                System.out.println("[1] Cadastrar");
                System.out.println("[2] Listar todos");
                System.out.println("[3] Listar por filtro");
                System.out.println("[4] Consultar");
                System.out.println("[5] Alterar");
                System.out.println("[6] Excluir");
                System.out.println("[0] Sair");
                System.out.println("=========================");

                try{
                    System.out.print("Escolha uma opção: ");
                    opc = Integer.parseInt(scanner.nextLine());
                }catch (Exception e) {
                    System.out.println("ERRO: Informe um valor valido!");
                }

                switch (opc) {
                    case 1:
                        cadastrar();
                        break;

                    case 2:
                        listar();
                        break;

                    case 3:
                        listarPorFiltro();
                        break;

                    case 4:
                        consultar();
                        break;

                    case 5:
                        alterar();
                        break;

                    case 6:
                        excluir();
                        break;

                    case 0:
                        System.out.println("Voltando...\n");
                        Sistema.main(null);
                        break;

                    default:
                        System.out.println("ERRO: Opção invalida!");
                        break;
                }
            } while (opc != 0);
        }catch(Exception e){
            System.out.println("\nERRO: " + e.getMessage());
        }
    }

    public void cadastrar(){

    }

    public void listar(){
        ArrayList<User> users = genericDao.buscarTodos(User.class);

        System.out.println("=== USUÁRIOS DEMONÍACOS REGISTRADOS ===");

        if(users.isEmpty()){
            System.out.println("\nNenhum usuário demoníaco registrado.\n");
            
            return;
        }

        System.out.printf("| %-5s | %-20s | %-20s | %-20s\n", "ID", "NOME", "NÍVEL", "INVOCAÇÃO", "JOGO");

        for(User usr : users){
            System.out.printf("| %-5d | %-20s | %-20s | %-20s\n",
                usr.getId(),
                usr.getNome(),
                usr.getNivel(),
                usr.getInvocacao().getInvocacao(),
                usr.getJogo().getSerieJogo()
            );
        }
    }

    public void listarPorFiltro(){
        System.out.println("=== BUSCAR POR FILTRO ===\n");

        try{
            String campo = "";
            System.out.println("\nCampo que deseja filtrar:");
            campo = scanner.nextLine();
            
            String filtro = "";
            System.out.println("Filtro desejado: ");
            filtro = scanner.nextLine();
    
            ArrayList<User> users = genericDao.buscarTodosFiltro(User.class, campo, filtro);
    
            System.out.println("\n=== LISTA FILTRADA ===");
            if(users.isEmpty()){
                System.out.println("Nenhum usuário demoníaco encontrado.");
    
                return;
            }
    
            System.out.printf("| %-5s | %-20s | %-20s | %-15s\n", "ID", "NOME", "NÍVEL", "FRAQUEZA");
            for(User usr : users){
                System.out.printf("| %-5s | %-20s | %-20s | %-15s\n", 
                    usr.getId(),
                    usr.getNome(),
                    usr.getNivel(),
                    usr.getInvocacao().getInvocacao(),
                    usr.getJogo().getSerieJogo()
                );
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void consultar(){
        System.out.println("=== CONSULTA ÚNICA ===\n");

        try{
            System.out.println("Nome do usuário demoníaco:");
            String filtro = scanner.nextLine();

            User user = genericDao.consultar(User.class, "nome", filtro);

            if(user == null){
                System.out.println("Nenhum usuário demoníaco encontrado.");
            
                return;
            }

            System.out.println("\n=== INFORMAÇÕES ===\n");
            System.out.println("| ID: " + user.getId());
            System.out.println("| Nome: " + user.getNome());
            System.out.println("| Nível: " + user.getNivel());
            System.out.println("| Tipo de invocação: " + user.getInvocacao().getInvocacao());
            System.out.println("| Série-Jogo: " + user.getJogo().getSerieJogo());
            System.out.println();
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void alterar(){

    }

    public void excluir(){
        System.out.println("\n=== EXCLUIR REGISTRO ===\n");

        System.out.println("ID do usuário de demônio:");
        int id = Integer.parseInt(scanner.nextLine());

        int qtde = genericDao.excluir(User.class, "id", id);

        if(qtde > 0){
            System.out.println("Exclusão realizada.");
        }else{
            System.out.println("Nenhuma exclusão de registro foi realizada,");
        }
    }
}
