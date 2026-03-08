import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Programa{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>(); //criando o Hash
    public static void main(String[] args) throws Exception{
        Programa pg = new Programa(); //usado para chamar a função(método) "menu" 
        
        pg.menu(); //chamando o método menu
    }

    public void menu() throws Exception{
        String opc;
        do{
            System.out.println("[1]. Cadastrar aeroporto.");
            System.out.println("[2]. Listar aeroportos.");
            System.out.println("[3]. Remover aeroporto.");
            System.out.println("[4]. Consultar aeroporto através da sigla.");
            System.out.println("[0]. Sair.");
            System.out.println("");
            System.out.println("Selecione uma opção:");
            opc = Programa.reader.readLine();

            switch(opc){
                case "1":
                    cadastrarAeroporto();
                break;

                case "2":
                    System.out.println("=== LISTANDO AEROPORTOS CADASTRADOS ===");
                    System.out.println("");
                    listarAeroportos();
                break;

                case "3":
                    System.out.println("=== REMOVENDO AEROPORTO ===");
                    System.out.println("");
                    removerAeroporto();
                break;

                case "4":
                    System.out.println("=== PROCURANDO POR SIGLA ===");
                    System.out.println("");
                    procurarPorSigla();
                break;

                case "0":
                    System.out.println("Saindo...");
                break;

                default:
                    System.out.println("Opção inválida.");
            }
        }while(!opc.equals("0"));
    }

    public void cadastrarAeroporto(){
        //TO-DO: tratamentos de erros
        String nome;
        String cidade;
        Double altitude;
        String sigla;

        try{ //tenta executar os comandos de cadastro
            Aeroporto aero = new Aeroporto();
                
            System.out.println("Sigla do aeroporto:");
            sigla = Programa.reader.readLine();

            System.out.println("Nome do aeroporto:");
            nome = Programa.reader.readLine();
            aero.setNome(nome);

            System.out.println("Cidade:");
            cidade = Programa.reader.readLine();
            aero.setCidade(cidade);

            System.out.println("Altitude:");
            altitude = Double.valueOf(Programa.reader.readLine());
            aero.setAltitude(altitude);

            aeroportos.put(sigla, aero);
        }catch(Exception e){ //caso não consiga
            System.out.println(e); //mostra o erro no terminal(tela)
        }
    }

    public void listarAeroportos(){
        System.out.println("Informações dos aeroportos: ");
        for(Aeroporto aero : aeroportos.values()){ //percorrendo o HashMap com foreach
                System.out.println("Nome:" + aero.getNome() + "\nCidade: " + aero.getCidade() + "\nAltitude: " + aero.getAltitude());
                System.out.println("");
                System.out.println("");
        }
    }

    public void removerAeroporto(){
        //TO-DO: tratamentos de erros
        String sigla = "";

        try{
            do{
                System.out.println("Sigla do aeroporto que deseja remover:");
                sigla = Programa.reader.readLine();

                if(aeroportos.containsKey(sigla)){
                    System.out.println("");
                    System.out.println("Aeroporto existente.");
                    System.out.println("Apagando aeroporto cadastrado.");
                    System.out.println("");
                    aeroportos.remove(sigla);
                    System.out.println("Aeroporto removido!");
                    System.out.println("");
                }else{
                    System.out.println("");
                    System.out.println("Aeroporto não encontrado.");
                    System.out.println("");
                }
            }while(sigla == null);
        }catch(IOException ioE){
            System.out.println(ioE);
        }
    }

    public void procurarPorSigla(){
        //TO-DO: tratamentos de erros
        String sigla = "";
        try{
            do{
                System.out.println("Sigla do aeroporto que deseja procurar:");
                sigla = Programa.reader.readLine();

                if(aeroportos.containsKey(sigla)){
                    System.out.println("Dados do aeroporto com a sigla (" + sigla + "):");
                    System.out.println("");
                    for(Aeroporto aero : aeroportos.values()){
                        System.out.println("Nome:" + aero.getNome() + "\nCidade: " + aero.getCidade() + "\nAltitude: " + aero.getAltitude());
                    }
                    System.out.println("");
                }else{
                    System.out.println("");
                    System.out.println("Não existe aeroporto com a sigla " + sigla);
                    System.out.println("");
                }
            }while(sigla == null);
        }catch(IOException ioE){
            System.out.println(ioE);
        }
    }
}
