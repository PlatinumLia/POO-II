package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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


    public ArrayList<Veiculo> listarTodos(){
        ArrayList<Veiculo> resultados = new ArrayList<>();

        //consulta ao banco
        try{
            this.conectar();

            ResultSet rs = stm.executeQuery("SELECT * FROM tb_veiculos ORDER BY modelo");

            //popular arraylist
            while(rs.next()){ 
                Veiculo vei = new Veiculo(); //cria novo objeto para guardar os dados 
                                            // contidos na tabela, no campo referente a ele

                vei.setCodigo(rs.getInt("codigo"));
                vei.setMarca(rs.getString("marca"));
                vei.setModelo(rs.getString("modelo"));
                vei.setChassi(rs.getString("chassi"));
                vei.setAno(rs.getInt("ano"));

                resultados.add(vei); //adicionando ao arraylist
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }


        return resultados;
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

    public int excluir(int codigo){
        int qtde = 0;

        try{
            this.conectar();
            
            String comando = "DELETE FROM tb_veiculos WHERE codigo = " + codigo + ";";

            stm.executeUpdate(comando);
            
            qtde = stm.getUpdateCount();
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return qtde;
    }

    public Veiculo consultar(int codigo){
        Veiculo vei = null;

        //consulta ao banco
        try{
            this.conectar();

            ResultSet rs = stm.executeQuery("SELECT * FROM tb_veiculos WHERE codigo = " + codigo + ";");

            //popular arraylist
            while(rs.next()){ 
                vei = new Veiculo(); //cria novo objeto para guardar os dados 
                                            // contidos na tabela, no campo referente a ele

                vei.setCodigo(rs.getInt("codigo"));
                vei.setMarca(rs.getString("marca"));
                vei.setModelo(rs.getString("modelo"));
                vei.setChassi(rs.getString("chassi"));
                vei.setAno(rs.getInt("ano"));
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return vei;
    }

    
    public int alterar(Veiculo vei){
        int qtde = 0;
        
        try{
            this.conectar();
            
            String comando = "UPDATE tb_veiculos SET " 
            + "marca = '" + vei.getMarca() + "', " 
            + "modelo = '" + vei.getModelo() + "', " 
            + "chassi = '" + vei.getChassi() + "', " 
            + "ano = '" + vei.getAno() + "' "
            + " WHERE codigo = " + vei.getCodigo() + ";";

            System.out.println(comando);
            stm.executeUpdate(comando);
            qtde = stm.getUpdateCount();
        }catch(Exception e){
            System.out.println("Erro ao inserir regsitro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return qtde;
    }
}