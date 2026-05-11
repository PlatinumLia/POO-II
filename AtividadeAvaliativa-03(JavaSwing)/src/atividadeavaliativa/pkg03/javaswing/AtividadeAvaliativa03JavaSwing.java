/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividadeavaliativa.pkg03.javaswing;

import java.util.ArrayList;
import model.DaoLivro;
import model.Livro;
import view.LivroView;

/**
 *
 * @author aluno.lab
 */
public class AtividadeAvaliativa03JavaSwing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoLivro daoLivro = new DaoLivro();
        ArrayList<Livro> livros = daoLivro.listarTodos();
        
        // verno terminal os dados que há no banco assim que a aplicação é executada
        for(Livro livro : livros){
            System.out.println(livro.getNome());
        }
        
        /* deixa a aparência mais moderna */
        //com.formdev.flatlaf.FlatLightLaf.setup();    // Tema Claro
        com.formdev.flatlaf.FlatDarkLaf.setup();     // Tema Escuro
        
        
        new LivroView().setVisible(true);
    }   
}