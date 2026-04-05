import java.sql.Statement;
import java.sql.Connection;

public class DaoVendedor{
    private Connection conn;
    private Statement stm;

    private void conectar(){ //método para conectar ao banco
                            // sem precisar ficar usando o comandos toda vez que precisar conectar
        try{
            this.conn = GerenciadorConexao.pegarConexao();
            this.stm = conn.createStatement();
        }catch(Exception e1){
            System.out.println("Erro: " + e1.getMessage());
        }
    }
    
    private void desconectar(){
        try{
            this.stm.close();
            this.conn.close();
        }catch(Exception e1){
            System.out.println("Erro: " + e1.getMessage());
        }
    }
}
