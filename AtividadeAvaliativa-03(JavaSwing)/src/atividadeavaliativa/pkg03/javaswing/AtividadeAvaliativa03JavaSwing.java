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
        
        for(Livro livro : livros){
            System.out.println(livro.getNome());
        }
        
        new LivroView().setVisible(true);
    }   
}