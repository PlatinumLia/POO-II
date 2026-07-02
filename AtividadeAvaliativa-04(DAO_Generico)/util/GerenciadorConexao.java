package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
    private static Connection conexao;
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        /*
            Quando em outro computador, 
             mudar os atributos abaixo para poder funcionar nele
        */
        
        //Pegar conexão com o banco de dados no PC da faculdade
        String url = "jdbc:mysql://127.0.0.1/db_compendium";
        String user = "root";
        String passwd = "bancodedados";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection(url, user, passwd);

        return conexao;
    }
}