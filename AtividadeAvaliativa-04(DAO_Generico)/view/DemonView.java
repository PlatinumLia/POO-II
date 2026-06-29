package view;

import java.util.ArrayList;
import java.util.Scanner;

import dao.GenericDao;
import enums.TiposHabilidadesEnum;
import model.Demon;

public class DemonView {
    private Scanner scanner;
    private GenericDao genericDao;
    
    public DemonView(){
        scanner = new Scanner(System.in);
        genericDao = new GenericDao();
    }

    public void exibirMenu() throws Exception {
        try{
            int opc = -1;

            do {
                System.out.println("\n=======MENU DEMON=======");
                System.out.println("[1]. Cadastrar.");
                System.out.println("[2]. Listar todos.");
                System.out.println("[3]. Listar por filtro.");
                System.out.println("[4]. Consultar.");
                System.out.println("[5]. Alterar.");
                System.out.println("[6]. Excluir.");
                System.out.println("[0]. Sair.");
                System.out.println("=========================");

                try{
                    System.out.print("Escolha uma opção: ");
                    opc = Integer.parseInt(scanner.nextLine());
                }catch (Exception e){
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
            System.out.println();
            System.out.println("ERRO: " + e.getMessage());
            System.out.println();
        }
    }

    public void cadastrar(){
        System.out.println("=== ENTRADA DE DEMÔNIOS ===");

        try{
            Demon d = new Demon();

            String nome = "";
            while(nome.equals("") || nome.length() < 3){
                System.out.println("| Nome:");
                nome = scanner.nextLine();
                
                if(nome.length() < 3){
                    System.out.println("O nome não pode ter menos que 3 caracteres e nem ser vazio.");
                }else{
                    if(!nome.equals("") || nome.length() >= 3){
                        d.setNome(nome);
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
                    d.setNivel(nivel);
                }
            }
            
            int identificador = 0;
            while(identificador < 1 || identificador > 11){
                System.out.println("=== TIPOS ELEMENTAIS ===\n");
                System.out.println("| [1]. Phsyical.");
                System.out.println("| [2]. Gun.");
                System.out.println("| [3]. Fire.");
                System.out.println("| [4]. Ice.");
                System.out.println("| [5]. Electric.");
                System.out.println("| [6]. Wind.");
                System.out.println("| [7]. Psychokinesis.");
                System.out.println("| [8]. Nuclear");
                System.out.println("| [9]. Bless.");
                System.out.println("| [10]. Curse.");
                System.out.println("| [11]. Almigthy.");
                
                try{
                    System.out.println("| Fraqueza:");
                    identificador = Integer.parseInt(scanner.nextLine());
                    
                    if(identificador < 1 || identificador > 11){
                        System.out.println();
                        System.out.println("Selecione um tipo elemental válido.");
                        System.out.println();
                    }else{
                        if(identificador != 0 || identificador <= 11){
                            TiposHabilidadesEnum th = TiposHabilidadesEnum.fromIdentificador(identificador);
                            
                            d.setFraqueza(th);
                        }else{
                            System.out.println();
                            System.out.println("A fraqueza elemental do demônio não pode ser vazia.");
                            System.out.println();
                        }
                    }
                }catch(Exception e){
                    System.out.println("Erro: " + e.getMessage());
                }
            }

            genericDao.inserir(d);
        }catch(Exception e){
            System.out.println();
            System.out.println("Erro: " + e.getMessage());
            System.out.println();
        }
    }

    public void listar(){
        ArrayList<Demon> demons = genericDao.buscarTodos(Demon.class);

        System.out.println("=== DÊMONIOS REGISTRADOS ===");

        if(demons.isEmpty()){
            System.out.println("\nNenhum dêmonio registrado.\n");
            
            return;
        }

        System.out.printf("| %-5s | %-20s | %-20s | %-20s\n", "ID", "NOME", "NÍVEL", "FRAQUEZA");

        for(Demon d : demons){
            System.out.printf("| %-5d | %-20s | %-20s | %-20s\n",
            d.getId(),
            d.getNome(),
            d.getNivel(),
            d.getFraqueza().getHabilidade());
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
    
            ArrayList<Demon> demons = genericDao.buscarTodosFiltro(Demon.class, campo, filtro);
    
            System.out.println("\n=== LISTA FILTRADA ===");
            if(demons.isEmpty()){
                System.out.println("Nenhum demônio encontrado.");
    
                return;
            }
    
            System.out.printf("| %-5s | %-20s | %-20s | %-15s\n", "ID", "NOME", "NÍVEL", "FRAQUEZA");
            for(Demon d : demons){
                System.out.printf("| %-5s | %-20s | %-20s | %-15s\n", 
                    d.getId(),
                    d.getNome(),
                    d.getNivel(),
                    d.getFraqueza().getHabilidade()
                );
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void consultar(){
        System.out.println("\n=== CONSULTA ÚNICA ===\n");

        try{
            System.out.println("Informe o nome do demônio registrado:");
            String filtro = scanner.nextLine();

            Demon demons = genericDao.consultar(Demon.class, "nome", filtro);

            if(demons == null){
                System.out.println("Nenhum demônio encontrado.");

                return;
            }

            System.out.println("\n=== RESULTADO ===");
            System.out.println("ID: " + demons.getId());
            System.out.println("Nome: " + demons.getNome());
            System.out.println("Nível: " + demons.getNivel());
            System.out.println("Fraqueza: " + demons.getFraqueza().getHabilidade());
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void alterar(){
         System.out.println("\n=== ALTERAR REGISTRO ===\n");

        try{
            System.out.println("Informe o id do demônio registrado:");
            String filtro = scanner.nextLine();

            Demon demon = genericDao.consultar(Demon.class, "id", filtro);

            if(demon == null){
                System.out.println("Nenhum demônio encontrado.");

                return;
            }

            int identificador;
            do{
                System.out.println("\n=== DADOS ===\n");
                System.out.println("| ID: " + demon.getId());
                System.out.println("| [1]. Nome: " + demon.getNome());
                System.out.println("| [2]. Nível: " + demon.getNivel());
                System.out.println("| [3]. Fraqueza: " + demon.getFraqueza().getHabilidade());
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
                            demon.setNome(scanner.nextLine());
                        break;

                        case 2:
                            System.out.println("| Nível:");
                            demon.setNivel(Integer.parseInt(scanner.nextLine()));
                        break;

                        case 3:
                            int identificadorFraqueza;

                            System.out.println("=== TIPOS ELEMENTAIS ===\n"); 
                            System.out.println("| [1]. Phsyical.");
                            System.out.println("| [2]. Gun.");
                            System.out.println("| [3]. Fire.");
                            System.out.println("| [4]. Ice.");
                            System.out.println("| [5]. Electric.");
                            System.out.println("| [6]. Wind.");
                            System.out.println("| [7]. Psychokinesis.");
                            System.out.println("| [8]. Nuclear");
                            System.out.println("| [9]. Bless.");
                            System.out.println("| [10]. Curse.");
                            System.out.println("| [11]. Almigthy.");

                            do{
                                try{
                                    System.out.println("| Fraqueza:");
                                    identificadorFraqueza = Integer.parseInt(scanner.nextLine());
    
                                    TiposHabilidadesEnum th = TiposHabilidadesEnum.fromIdentificador(identificadorFraqueza);
                                    demon.setFraqueza(th);

                                    if(identificadorFraqueza < 1 || identificadorFraqueza > 11){
                                        System.out.println("\nSelecione um valor válido.\n");
                                    }
                                }catch(Exception e){
                                    System.out.println("Erro: " + e.getMessage());
                                    identificadorFraqueza = -1;
                                }
                            }while(identificadorFraqueza < 1 || identificadorFraqueza > 11);
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

            int qtde = genericDao.alterar(demon, "id", demon.getId());

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
        System.out.println("=== EXCLUIR REGISTRO ===");

        System.out.println("Informe o ID de registro do demônio:");
        int id = Integer.parseInt(scanner.nextLine());

        int qtde = genericDao.excluir(Demon.class, "id", id);

        if(qtde > 0){
            System.out.println("Exclusão feita com sucesso.");
        }else{
            System.out.println("Nenhuma exclusão feita.1");
        }
    }
}
