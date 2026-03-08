import java.io.BufferedReader;
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

                case "0":
                    System.out.println("Saindo...");
                break;

                default:
                    System.out.println("Opção inválida.");
                    throw new AssertionError();
            }
        }while(!opc.equals("0"));
    }

    public void cadastrarAeroporto(){
        String nome;
        String cidade;
        Double altitude;
        String sigla;
        String opc = "";

        try{ //tenta executar os comandos de cadastro
            do{
                Aeroporto aero = new Aeroporto();

                System.out.println("Nome do aeroporto:");
                nome = Programa.reader.readLine();
                aero.setNome(nome);

                System.out.println("Cidade:");
                cidade = Programa.reader.readLine();
                aero.setCidade(cidade);

                System.out.println("Altitude:");
                altitude = Double.valueOf(Programa.reader.readLine());
                aero.setAltitude(altitude);

                System.out.println("Sigla do estado:");
                sigla = Programa.reader.readLine();

                Programa.aeroportos.put(sigla, aero); //colocando 

                System.out.println("");
                System.out.println("Deseja cadastarar outro aeroporto? [S/N]");
                opc = Programa.reader.readLine().toUpperCase();
                if(opc.equals("N")){
                    System.out.println("");
                    System.out.println("Voltando ao menu...");
                    System.out.println("");
                }else if(opc != "S"){
                    System.out.println("");
                    System.out.println("Opção inválida!");
                    System.out.println("Use S ou N...");
                    System.out.println("");
                }

            }while(!opc.equals("N") || opc != "S");
        }catch(Exception e){ //caso não consiga
            System.out.println(e); //mostra o erro no terminal(tela)
        }
    }
}
