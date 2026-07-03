package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.GenericDao;
import enums.TipoInvocacaoEnum;
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
    System.out.println("=== REGISTRO DE USUÁRIO ===");

        try{
            User u = new User();

            String nome = "";
            while(nome.equals("") || nome.length() < 3){
                System.out.println("| Nome:");
                nome = scanner.nextLine();
                
                if(nome.length() < 3){
                    System.out.println("O nome não pode ter menos que 3 caracteres e nem ser vazio.");
                }else{
                    if(!nome.equals("") || nome.length() >= 3){
                        u.setNome(nome);
                    }
                }
            }
            
            int nivel = -1;
            while(nivel <= 0 || nivel > 100){
                System.out.println("| Nível: ");
                nivel = Integer.parseInt(scanner.nextLine());
                
                if(nivel <= 0 || nivel > 100){
                    System.out.println();
                    System.out.println("O nível não pode ser menor ou igual a 0 e nem maior que 100.");
                    System.out.println();
                }else{
                    u.setNivel(nivel);
                }
            }
            
            int identificador = 0;
            while(identificador < 1 || identificador > 11){
                System.out.println("=== TIPOS DE INVOCAÇÃO ===\n");
                System.out.println("| [1]. Evoker.");
                System.out.println("| [2]. Máscara");
                System.out.println("| [3]. Carta.");
                System.out.println("| [4]. Recrutar.");
                
                try{
                    System.out.println("| Invocação:");
                    identificador = Integer.parseInt(scanner.nextLine());
                    
                    if(identificador < 1 || identificador > 11){
                        System.out.println();
                        System.out.println("Selecione uma forma de invocação válida.");
                        System.out.println();
                    }else{
                        if(identificador != 0 || identificador <= 11){
                            TipoInvocacaoEnum ti = TipoInvocacaoEnum.fromIdentificador(identificador);
                            
                            u.setTipoInvocacao(ti);
                        }else{
                            System.out.println();
                            System.out.println("A forma de invocação que o usuário utiliza não pode ser vazia.");
                            System.out.println();
                        }
                    }
                }catch(Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            genericDao.inserir(u);
        }catch(Exception e){
            System.out.println();
            System.out.println("Erro: " + e.getMessage());
            System.out.println();
        }
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
                usr.getInvocacao().getInvocacaoNome()
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
                    usr.getInvocacao().getInvocacaoNome()
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
            System.out.println("| Tipo de invocação: " + user.getInvocacao().getInvocacaoNome());
            System.out.println();
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void alterar(){
    System.out.println("\n=== ALTERAR REGISTRO ===\n");

        try{
            System.out.println("Informe o id do usuário demoníaco registrado:");
            String filtro = scanner.nextLine();

            User user = genericDao.consultar(User.class, "id", filtro);

            if(user == null){
                System.out.println("Nenhum usuário demoníaco encontrado.");

                return;
            }

            int identificador;
            do{
                System.out.println("\n=== DADOS ===\n");
                System.out.println("| ID: " + user.getId());
                System.out.println("| [1]. Nome: " + user.getNome());
                System.out.println("| [2]. Nível: " + user.getNivel());
                System.out.println("| [3]. Invocação: " + user.getInvocacao().getInvocacaoNome());
                System.out.println("| [0]. Voltar");
            
                try{
                    System.out.println("Escolha uma opção:");
                    identificador = Integer.parseInt(scanner.nextLine());
                }catch(Exception e){
                    System.out.println("Erro: " + e.getMessage());
                    identificador = -1;
                }

                if(identificador < 0 || identificador > 3){
                    System.out.println("\nInforme um valor válido.");
                }else{
                    switch(identificador){
                        case 1:
                            System.out.println("| Nome:");
                            user.setNome(scanner.nextLine());
                        break;

                        case 2:
                            System.out.println("| Nível:");
                            user.setNivel(Integer.parseInt(scanner.nextLine()));
                        break;

                        case 3:
                            int identificadorInvocacao;

                            System.out.println("=== TIPOS DE INVOCAÇÃO ===\n");
                            System.out.println("| [1]. Evoker.");
                            System.out.println("| [2]. Máscara");
                            System.out.println("| [3]. Carta.");
                            System.out.println("| [4]. Recrutar.");

                            do{
                                try{
                                    System.out.println("| Invocação:");
                                    identificadorInvocacao = Integer.parseInt(scanner.nextLine());
    
                                    TipoInvocacaoEnum ti = TipoInvocacaoEnum.fromIdentificador(identificadorInvocacao);
                                    user.setTipoInvocacao(ti);

                                    if(identificadorInvocacao < 1 || identificadorInvocacao > 11){
                                        System.out.println("\nSelecione um valor válido.\n");
                                    }
                                }catch(Exception e){
                                    System.out.println("Erro: " + e.getMessage());
                                    identificadorInvocacao = -1;
                                }
                            }while(identificadorInvocacao < 1 || identificadorInvocacao > 11);
                        break;

                        case 0:
                            System.out.println("Voltando . . .");
                            break;

                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }
            }while(identificador != 0);

            int qtde = genericDao.alterar(user, "id", user.getId());

            if(qtde > 0){
                System.out.println("Alterado com sucesso.");
            }else{
                System.out.println("Nenhuma alteração feita.");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
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
