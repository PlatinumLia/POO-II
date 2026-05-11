/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aluno.lab
 */
public class DaoLivro {
    private Connection conn;
    private Statement stm;
    
    private void conectar(){ //método para conectar ao banco
                            // sem precisar ficar usando o comandos toda vez que precisar conectar
        try{
            this.conn = GerenciadorConexao.getConnection();
            this.stm = conn.createStatement();
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private void desconectar(){
        try{
            this.stm.close();
            this.conn.close();
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public boolean inserir(Livro livro){
        boolean resultado = false;
        
        try{
            this.conectar(); //tenta conectar ao banco
            
            String comando = "INSERT INTO tb_livros VALUES"
                    + "(" + "NULL, '"
                    + livro.getNome() + "', '"
                    + livro.getAutor() + "', '"
                    + livro.getQtdPaginas() + "', '"
                    + livro.getAnoLancamento() + "', '" 
                    + livro.getGenero() + "');";
            
            System.out.println(comando);
            stm.executeUpdate(comando);
            resultado = true;
        }catch(SQLException e){ //caso não consiga conectar ou dê erro ao inserir, 
                            // mostra uma msg no terminal
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        
        return resultado;
    }
    
    public ArrayList<Livro> listarTodos(){
        ArrayList<Livro> results = new ArrayList<>();
        
        try{ //consulta ao banco
            this.conectar(); //tenta conectar ao banco
            
            // acessa a tabela "tb_livros", executa uma QUERRY de SELECT
            // e ordena pelo código dos livros
            ResultSet rs = stm.executeQuery("SELECT * FROM tb_livros ORDER BY codigo");
            
            while(rs.next()){ //colocar os dados da tabela do MYSQL no ArrayList
                Livro livro = new Livro();
                
                // definindo cada elemento da classe Livro 
                //  com os dados obtidos de cada campo da tabela
                livro.setId(rs.getInt("codigo"));
                livro.setNome(rs.getString("nome"));
                livro.setAutor(rs.getString("autor"));
                livro.setQtdPaginas(rs.getInt("qtd_paginas"));
                livro.setAnoLancamento(rs.getInt("ano_lancamento"));
                livro.setGenero(rs.getString("genero"));
                
                results.add(livro); // finalmente adicionando as informações no ArrayList
            }
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        
        return results;
    }
    
    public Livro consultar(int codigo){
        Livro liv = null;
        
        try{
            this.conectar();
            
            ResultSet rs = stm.executeQuery("SELECT * FROM tb_livros WHERE codigo = " + codigo + ";");
            
            while(rs.next()){
                liv = new Livro();
                
                liv.setId(rs.getInt("codigo"));
                liv.setNome(rs.getString("nome"));
                liv.setAutor(rs.getString("autor"));
                liv.setQtdPaginas(rs.getInt("qtd_paginas"));
                liv.setAnoLancamento(rs.getInt("ano_lancamento"));
                liv.setGenero(rs.getString("genero"));
            }
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        
        return liv;
    }
    
    public int excluir(int codigo){
        int qtde = 0;
        
        try{
            this.conectar();
            
            String comando = "DELETE FROM tb_livros WHERE codigo = " + codigo + ";";
            
            System.out.println(comando);
            stm.executeUpdate(comando);
            qtde = stm.getUpdateCount();
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        
        return qtde;
    }
    
    public int alterar(Livro liv){
        int qtde = 0;
        
        try{
            this.conectar();
            
            String comando = "UPDATE tb_livros SET "
                           + "nome = '" + liv.getNome() + "', "
                           + "autor = '" + liv.getAutor() + "', "
                           + "qtd_paginas = " + liv.getQtdPaginas() + ", "
                           + "ano_lancamento = " + liv.getAnoLancamento() + ", "
                           + "genero = '" + liv.getGenero() + "' "
                           + "WHERE codigo = " + liv.getId() + ";";
            
            System.out.println(comando);
            stm.executeUpdate(comando);
            qtde = stm.getUpdateCount();
        }catch(SQLException e){
            System.out.println("Erro ao alterar registro.");
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        
        return qtde;
    }
}