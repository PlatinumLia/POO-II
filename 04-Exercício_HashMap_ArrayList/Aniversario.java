import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Aniversario{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<String> nomes = new ArrayList<>();
    HashMap<String, ArrayList<String>> aniversariantes = new HashMap<String, ArrayList<String>>();
    public static void main(String[] args) {
        Aniversario anv = new Aniversario();
    
        anv.menu();
    }

    public void menu(){
        String opc;
        try{
            do{ 
                System.out.println("MENU");
                System.out.println("[1]. Adicionar aniversariante.");
                System.out.println("[2]. Datas que contém aniversariantes.");
                System.out.println("[3]. Aniversários em determianda data.");
                System.out.println("[0]. Sair.");
                System.out.println("");
    
                System.out.println("Escolha uma opção:");
                opc = this.reader.readLine();
    
                switch(opc){
                    case "1":
                        adicionarAniversariante();    
                    break;
                
                    default:
                        break;
                }
            }while(opc.equals(""));
        }catch(IOException ioE){
            System.out.println("Erro: " + ioE);
        }
    }

    public void adicionarAniversariante(){
        String nome = "";
        String data = "";
        
        try{
            while(nome.equals("")){
                System.out.println("Aniversariante:");
                nome = this.reader.readLine();
            }
            this.nomes.add(nome);

            while(data.equals("")){
                System.out.println("Data de aniversário:");
                data = this.reader.readLine();
            }

            if(!this.aniversariantes.containsKey(data)){
                this.aniversariantes.put(data, nomes);
            }
            this.aniversariantes.get(data).add(nome);
        }catch(Exception e){
        
        }
    }
}