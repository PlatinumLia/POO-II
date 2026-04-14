import java.sql.Connection;
import java.sql.Statement;

public class DaoVeiculo{
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
    
    public boolean inserir(Veiculo vei){
        boolean resultado = false;
        
        try{
            this.conectar();
            
            String comando = "INSERT INTO tb_veiculos VALUES(" + "NULL, '" + vei.getMarca() + "', '" + vei.getModelo() + "', '" + vei.getChassi() + "', " + vei.getAno() + ");";

            // System.out.println(comando);
            stm.executeUpdate(comando);
            resultado = true;
        }catch(Exception e){
            System.out.println("Erro ao inserir regsitro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return resultado;
    }
}