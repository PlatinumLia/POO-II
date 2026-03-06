import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Programa{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        Programa pg = new Programa();
        
        HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>();

        pg.menu();
    }

    private void menu() throws Exception{
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

        try{
            do{
                Aeroporto aero = new Aeroporto();

                System.out.println("Nome do aeroporto:");
                nome = Programa.reader.readLine();
                aero.setNome(nome);

                System.out.println("Cidade:");
                cidade = Programa.reader.readLine();
                aero.setCidade(cidade);

                System.out.println("Altitude:");
                //altitude = Programa.reader.readLine();
                //aero.setAltitude(altitude);

                System.out.println("Sigla do estado:");
                sigla = Programa.reader.readLine();
                

            }while(!opc.equals("N") || opc == null);
        }catch(Exception e){

        }
    }
}
