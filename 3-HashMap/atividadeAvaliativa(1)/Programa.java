import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Programa{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>(); //criando o Hash de forma estática 
                                                                                    // --> não será preciso criar uma nova instância toda vez que precisar chamá-lo
    public static void main(String[] args) throws Exception{
        Programa pg = new Programa(); //usado para chamar a função(método) "menu" 
        
        pg.menu(); //chamando o método menu
    }

    public void menu() throws Exception{
        String opc;
        do{
            System.out.println("=== MENU ===");
            System.out.println("");
            System.out.println("[1]. Cadastrar aeroporto.");
            System.out.println("[2]. Listar aeroportos.");
            System.out.println("[3]. Remover aeroporto.");
            System.out.println("[4]. Consultar aeroporto através da sigla.");
            System.out.println("[0]. Sair.");
            System.out.println("");
            System.out.println("Selecione uma opção:");
            opc = this.reader.readLine();

            switch(opc){
                case "1":
                    System.out.println("=== CADASTRANDO AEROPORTO ===");
                    cadastrarAeroporto();
                    System.out.println("");
                    break;

                case "2":
                    System.out.println("=== LISTANDO AEROPORTOS CADASTRADOS ===");
                    System.out.println("");
                    listarAeroportos();
                    System.out.println("");
                break;

                case "3":
                    System.out.println("=== REMOVENDO AEROPORTO ===");
                    System.out.println("");
                    removerAeroporto();
                    System.out.println("");
                break;

                case "4":
                    System.out.println("=== PROCURANDO POR SIGLA ===");
                    System.out.println("");
                    procurarPorSigla();
                    System.out.println("");
                break;

                case "0":
                    System.out.println("");
                    System.out.println("Saindo...");
                    System.out.println("");
                break;

                default:
                    System.out.println("Opção inválida.");
            }
        }while(!opc.equals("0"));
    }

    public void cadastrarAeroporto(){
        String nome = "";
        String cidade = "";
        String altitude = "";
        String sigla = "";

        try{ //tenta executar os comandos de cadastro
            Aeroporto aero = new Aeroporto();
                
            while(sigla.equals("")){ //enquanto receber uma string vazia
                                     //executa os seguintes comandos:
                System.out.println("");
                System.out.println("Sigla do aeroporto:");
                sigla = this.reader.readLine();

                if(sigla.equals("")){
                    System.out.println("");
                    System.out.println("Defina a sigla do aeroporto!");
                }
            }

            while(nome.equals("")){ //enquanto receber uma string vazia
                                    //executa os seguintes comandos:
                System.out.println("");
                System.out.println("Nome do aeroporto:");
                nome = this.reader.readLine();

                if(nome.equals("")){
                    System.out.println("");
                    System.out.println("O campo 'nome' não pode ser vazio!");
                }
            }
            aero.setNome(nome); //seta o atributo "nome" da classe Aeroporto

            while(cidade.equals("")){ //enquanto receber uma string vazia
                                     //executa os seguintes comandos:
                System.out.println("");
                System.out.println("Cidade:");
                cidade = this.reader.readLine();

                if(cidade.equals("")){
                    System.out.println("");
                    System.out.println("O campo 'cidade' não pode ser vazio!");
                }
            }
            aero.setCidade(cidade); //seta o atributo "cidade" da classe Aeroporto

            while(altitude.equals("")){ //enquanto receber uma string vazia
                                       //executa os seguintes comandos:
                System.out.println("");
                System.out.println("Altitude:");
                altitude = this.reader.readLine();

                if(altitude.equals("")){
                    System.out.println("");;
                    System.out.println("O campo 'altitude' não pode ser vazio!");
                }
            }
            aero.setAltitude(Double.valueOf(altitude)); //converte para "Double"
                                                       //e seta a altitude da classe Aeroporto

            aeroportos.put(sigla, aero); //coloca as informações no HashMap
        }catch(IOException ioE){ //caso não consiga
            System.out.println(ioE); //mostra o erro no terminal(tela)
        }
    }

    public void listarAeroportos(){
        System.out.println("Informações dos aeroportos: ");
        System.out.println("");
        for(Aeroporto aero : aeroportos.values()){ //percorrendo o HashMap com foreach
                System.out.println("Nome: " + aero.getNome() + "\nCidade: " + aero.getCidade() + "\nAltitude: " + aero.getAltitude());
                System.out.println("");
        }
    }

    public void removerAeroporto(){
        String sigla = "";

        try{ //tenta executar a sequência abaixo de comandos
            while(sigla.equals("")){ //enquanto receber uma string vazia
                                    // executa os seguintes comandos
                System.out.println("Sigla do aeroporto que deseja remover:");
                sigla = this.reader.readLine();
            }

            if(!aeroportos.containsKey(sigla)){
                System.out.println("");
                System.out.println("Aeroporto não encontrado.");
                System.out.println("");
            }else{
                System.out.println("");
                System.out.println("Aeroporto existente.");
                System.out.println("Apagando aeroporto cadastrado.");
                System.out.println("");
                aeroportos.remove(sigla);
                System.out.println("Aeroporto removido!");
                System.out.println("");
            }
        }catch(IOException ioE){ //caso não consiga executar
                                // retorna uma exceção de Input-Output
            System.out.println(ioE);
        }
    }

    public void procurarPorSigla(){
        String sigla = "";
        try{ //tenta executar os seguintes comandos:
            while(sigla.equals("")){ //executa os comandos abaixo enquanto receber uma string vazia
                System.out.println("Sigla do aeroporto que deseja procurar:");
                sigla = this.reader.readLine();

                if(sigla.equals("")){
                    System.out.println("");
                    System.out.println("O campo não pode ser vazio!\nTente novamente...");
                    System.out.println("");
                }
            }

            if(!aeroportos.containsKey(sigla)){ //caso não contenha a sigla digitada pelo user
                System.out.println("");
                System.out.println("Não existe aeroporto com a sigla " + sigla);
                System.out.println("");
            }else{ //se contém a sigla, executa os comandos
                System.out.println("");
                System.out.println("Dados do aeroporto com a sigla (" + sigla + "):");
                System.out.println("");
                System.out.println("Nome: " + aeroportos.get(sigla).getNome() + "\nCidade: " + aeroportos.get(sigla).getCidade() + "\nAltitude: " + aeroportos.get(sigla).getAltitude());
            }
        }catch(IOException ioE){ //caso não consiga executá-los
                                //mostra uma exceção de Input-Output
            System.out.println(ioE);
        }
    }
}
