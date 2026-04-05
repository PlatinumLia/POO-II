import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

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

    public boolean inserir(Vendedor vend){
        boolean inserido = false;

        try{
            this.conectar();
            String comando = "INSERT INTO tb_vendedor VALUES (" + "NULL, '" 
            + vend.getNome() + "', '" 
            + vend.getCpf() + "', '"
            + vend.getTelefone() + "', '"
            + vend.getEstadoCivil() + ");";
            
            stm.executeUpdate(comando);
            inserido = true;
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return inserido;
    }

    public int excluir(int codigo){
        int qtde = 0;

        try{
            this.conectar();

            String command = "DELETE FROM tb_vendedor WHERE codigo = " + codigo + ";";
            stm.executeUpdate(command);
            qtde = stm.getUpdateCount();
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return qtde;
    }

    public ArrayList<Vendedor> listarTodos(){
        ArrayList<Vendedor> listaVendedores = new ArrayList<>();

        try {
            this.conectar();

            ResultSet rs = stm.executeQuery("SELECT * FROM tb_vendedores");

            while(rs.next()){
                Vendedor vend = new Vendedor();

                vend.setCodigo(rs.getInt("codigo"));
                vend.setNome(rs.getString("nome"));
                vend.setCpf(rs.getString("cpf"));
                vend.setTelefone(rs.getString("telefone"));
                vend.setEstadoCivil(rs.getString("estadoCivil"));

                listaVendedores.add(vend);
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return listaVendedores;
    }

    public Vendedor consultarVendedorEspecifico(int codigo){
        Vendedor vend = null;

        try{
            this.conectar();

            ResultSet rs = stm.executeQuery("SELECT * FROM tb_vendedores WHERE codigo = " + codigo + ";");

            while(rs.next()){
                vend = new Vendedor();
                
                vend.setCodigo(rs.getInt("codigo"));
                vend.setNome(rs.getString("nome"));
                vend.setCpf(rs.getString("cpf"));
                vend.setTelefone(rs.getString("telefone"));
                vend.setEstadoCivil(rs.getString("estadoCivil"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return vend;
    }
}
