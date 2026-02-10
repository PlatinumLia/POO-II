
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrataExcecoesV2{
    public static void main(String[] args) {
        TrataExcecoesV2 te = new TrataExcecoesV2();
        
        //teste para caso exista o arquivo
        String result =  te.lerArq("arq.txt");
        System.out.println(result);
        System.out.println("");

        //teste caso não exista o arquivo
        result =  te.lerArq("arq2.txt");
        System.out.println(result);
    }

    public String lerArq(String nomeArq){
        String retorno = "OK";
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(nomeArq));        
            String linha;

            while((linha = reader.readLine()) != null){
                System.out.println(linha);
            }
        }catch(FileNotFoundException e1){
            retorno = "Arquivo não encontrado.";
        }catch(IOException e2){
            retorno = "Erro na leitura do arquivo.";
        }catch(Exception e3){
            retorno = "Erro inesperado.";
            retorno += "Detalhes: " + e3.getMessage();
        }finally{
            retorno += "Encerrando";
        }

        return retorno; 
    }
}