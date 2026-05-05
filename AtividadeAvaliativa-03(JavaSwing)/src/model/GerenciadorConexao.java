/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno.lab
 */
public class GerenciadorConexao {
    private static Connection conexao;
    
    public static Connection getConnection() throws SQLException{
        /*
            Quando em outro computador, 
             mudar os atributos abaixo para poder funcionar nele
        */
        
        String url = "jdbc:mysql://127.0.0.1/db_livraria";
        String user = "root";
        String senha = "bancodedados";
    
        conexao = DriverManager.getConnection(url, user, senha);

        return conexao;
    }
}