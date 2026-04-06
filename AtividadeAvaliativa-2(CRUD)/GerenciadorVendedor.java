import java.util.ArrayList;
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

                case 2:
                    this.consultarVendedorEspecifico();
                    break;

                case 3:
                    this.alterarDados();
                    break;

                case 4:
                    this.excluir();
                    break;
            
                case 5:
                    this.listarTodos();
                    break;
            
                default:
                    System.out.println("");
                    System.out.println("Opção inválida!");
                    System.out.println("");
            }
        }
    }

    private void cadastrar(){
        Vendedor vend = new Vendedor();
        String telefone = "";
        String estadoCivil = "";
        
        System.out.println("\n---------------------------");
        System.out.println("CADASTRO DE VENDEDOR(A)");
        System.out.println("---------------------------\n");
        
        String nome = "";
        while(nome.equals("")){
            System.out.println("Nome:");
            nome = scanner.nextLine();

            if(!nome.equals("")){
                vend.setNome(nome);
            }else{
                System.out.println("");
                System.out.println("Informe o nome do vendedor(a)");
                System.out.println("");
            }
        }

        String cpf = "";
        while(cpf.equals("")){
            System.out.println("CPF:");
            cpf = scanner.nextLine();

            if(!cpf.equals("")){
                vend.setCpf(cpf);
            }else{
                System.out.println("");
                System.out.println("Informe o CPF do vendedor(a)");
                System.out.println("");
            }
        }
        
        while(telefone.equals("")){
            System.out.println("Telefone:");
            telefone = scanner.nextLine();
            
            if(!telefone.equals("")){
                vend.setTelefone(telefone);
            }else{
                System.out.println("");
                System.out.println("Informe o telefone do vendedor(a)");
                System.out.println("");
            }
        }

        String opc = "";
        while(!estadoCivil.equals("A") && !estadoCivil.equals("B") && !estadoCivil.equals("C")){
            System.out.println("Estados civis disponíveis:");
            System.out.println("[A]. Solteiro(a)");
            System.out.println("[B]. Casado(a)");
            System.out.println("[C]. Divorciado(a)");
            System.out.println("");
            System.out.println("Selecione o estado civil do(a) vendedor(a):");
            opc = scanner.nextLine().toUpperCase();     
            
            if(opc.equals("A")){
                estadoCivil = "Solteiro(a)";
                vend.setEstadoCivil(estadoCivil);
            }else if(opc.equals("B")){
                estadoCivil = "Casado(a)";
                vend.setEstadoCivil(estadoCivil);
            }else if(opc.equals("C")){
                estadoCivil = "Divorciado(a)";
                vend.setEstadoCivil(estadoCivil);
            }else{
                System.out.println("");
                System.out.println("Opção inválida!");
                System.out.println("Tente novamente.");
                System.out.println("");
            }

            boolean inserido = daoVendedor.inserir(vend);
            if(inserido){
                System.out.println("");
                System.out.println("Dados inseridos com sucesso");
                System.out.println("");

                break;
            }
        }
    }

    private void excluir(){
        int cod;
        int qtde = 0;

        System.out.println("");
        System.out.println("--- EXCLUSÃO DO CADASTRO DE UM VENDEDOR");
        System.out.println("");

        try{
            System.out.println("Código do(a) vendedor(a) que deseja excluir:");
            cod = Integer.parseInt(scanner.nextLine());

            qtde = daoVendedor.excluir(cod);
            if(qtde > 0){
                System.out.println("");
                System.out.println("Excluído com sucesso!");
                System.out.println("");
            }else{
                System.out.println("");
                System.out.println("Não foi possível excluir.");
                System.out.println("");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void listarTodos(){
        ArrayList<Vendedor> vendedores = daoVendedor.listarTodos(); 

        System.out.println("");
        System.out.println("--- LISTANDO TODOS OS VENDEDORES ---");
        System.out.println("");
        for(Vendedor vend : vendedores){
            System.out.println("Código: " + vend.getCodigo() + "; Nome: " + vend.getNome() + "; CPF: " + vend.getCpf() + "; Telefone: " + vend.getTelefone() + "; Estado Civil: " + vend.getEstadoCivil());
        }
        System.out.println("");
    }

    private void consultarVendedorEspecifico(){
        System.out.println("");
        System.out.println("--- CONSULTA VENDEDOR ESPECÍFICO ---");
        System.out.println("");

        try{
            System.out.println("Código do vendedor:");
            int codigo = Integer.parseInt(scanner.nextLine());
            Vendedor vend = daoVendedor.consultarVendedorEspecifico(codigo);

            if(vend != null){
                System.out.println("\nDados do vendedor:\n");
                System.out.println("Código: " + vend.getCodigo());
                System.out.println("Nome: " + vend.getNome());
                System.out.println("CPF: " + vend.getCpf());
                System.out.println("Telefone: " + vend.getTelefone());
                System.out.println("Estado civil: " + vend.getEstadoCivil());
                System.out.println("");
            }else{
                System.out.println("");
                System.out.println("Não encontrado!");
                System.out.println("Código inválido ou incorreto.");
                System.out.println("");
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void alterarDados(){
        System.out.println("--- ALTERAR DADOS DE VENDEDOR ---");
        System.out.println("");

        System.out.println("Código do vendedor:");
        int codigo = Integer.parseInt(scanner.nextLine());
        Vendedor vend = daoVendedor.consultarVendedorEspecifico(codigo);

        if(vend != null){
            System.out.println("\nDados do vendedor:\n");
            System.out.println("Código: " + vend.getCodigo());
            System.out.println("Nome: " + vend.getNome());
            System.out.println("CPF: " + vend.getCpf());
            System.out.println("Telefone: " + vend.getTelefone());
            System.out.println("Estado civil: " + vend.getEstadoCivil());
            System.out.println("");

            menuAlterarDados(vend);
        }else{
            System.out.println("");
            System.out.println("Vendedor(a) não encontrado.");
            System.out.println("");
        }
    }

    private void menuAlterarDados(Vendedor vend){
        System.out.println("--- MENU DE ALTERAÇÃO DOS DADOS ---\n");
        System.out.println("[1]. Alterar nome");
        System.out.println("[2]. Alterar CPF");
        System.out.println("[3]. Alterar telefone");
        System.out.println("[4]. Alterar estado civil");
        System.out.println("\nOpção desejada:");
        int opc = Integer.parseInt(scanner.nextLine());
        String nome = "";
        String cpf = "";
        String telefone = "";
        String estadoCivil = "";

        switch(opc){
            case 1:
                System.out.println("");
                System.out.println("Digite o novo nome:");
                nome = scanner.nextLine();

                if(!nome.isEmpty()){
                    vend.setNome(nome);
                }
            break;

            case 2:
                System.out.println("");
                System.out.println("Digite o novo CPF:");
                cpf = scanner.nextLine();
                
                if(!cpf.isEmpty()){
                    vend.setCpf(cpf);
                }    
            break;
                
            case 3:
                System.out.println("");
                System.out.println("Digite o novo telefone:");
                telefone = scanner.nextLine();

                if(!telefone.isEmpty()){
                    vend.setTelefone(telefone);
                }
            break;

            case 4:
                String opcao = "";
                while(!estadoCivil.equals("A") && !estadoCivil.equals("B") && !estadoCivil.equals("C")){
                    System.out.println("");
                    System.out.println("Estados civis disponíveis:");
                    System.out.println("[A]. Solteiro(a)");
                    System.out.println("[B]. Casado(a)");
                    System.out.println("[C]. Divorciado(a)");
                    System.out.println("");
                    System.out.println("Selecione o estado civil do(a) vendedor(a):");
                    opcao = scanner.nextLine().toUpperCase(); 
                    
                    if(opcao.equals("A")){
                        estadoCivil = "Solteiro(a)";
                        vend.setEstadoCivil(estadoCivil);
                        break;
                    }else if(opcao.equals("B")){
                        estadoCivil = "Casado(a)";
                        vend.setEstadoCivil(estadoCivil);
                        break;
                    }else if(opcao.equals("C")){
                        estadoCivil = "Divorciado(a)";
                        vend.setEstadoCivil(estadoCivil);
                        break;
                    }else{
                        System.out.println("");
                        System.out.println("Opção inválida!");
                        System.out.println("Tente novamente.");
                        System.out.println("");
                    }
                }
            break;
        
            default:
                System.out.println("");
                System.out.println("Opção inválida.");
                System.out.println("");
            break;

        }
        
        int qtde = daoVendedor.alterar(vend);
        if(qtde > 0){
            System.out.println("");
            System.out.println("Alterado com sucesso");
            System.out.println("");
        }else{
            System.out.println("");
            System.out.println("Não foi possível atualizar.");
            System.out.println("");
        }
    }
}