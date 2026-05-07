/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Livro;

/**
 *
 * @author aluno.lab
 */
public class LivroTableModel extends AbstractTableModel{
    public static final int COL_CODIGO = 0;
    public static final int COL_NOME = 1;
    public static final int COL_AUTOR = 2;
    public static final int COL_PAGINAS = 3;
    public static final int COL_LANCAMENTO = 4;
    public static final int COL_GENERO = 5;
    
    public ArrayList<Livro> listaLivros;
    
    public LivroTableModel(ArrayList<Livro> livros){ //método construtor
        this.listaLivros = livros;
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public int getRowCount(){
        return listaLivros.size();
    }
   
    @Override
    public String getColumnName(int col){
        String nome = "";
        
        if(col == COL_CODIGO){nome = "Código";}
        if(col == COL_NOME){nome = "Título do livro";}
        if(col == COL_AUTOR){nome = "Autor";}
        if(col == COL_PAGINAS){nome = "Páginas";}
        if(col == COL_LANCAMENTO){nome = "Ano de lançamento";}
        if(col == COL_GENERO){nome = "Gênero literário";}
        
        return nome;
    }
    
    @Override
    public Object getValueAt(int row, int col){
        Livro livro = listaLivros.get(row);
        Object content = "";
        
        if(col == COL_CODIGO){content = livro.getId();}
        if(col == COL_NOME){content = livro.getNome();}
        if(col == COL_AUTOR){content = livro.getAutor();}
        if(col == COL_PAGINAS){content = livro.getQtdPaginas();}
        if(col == COL_LANCAMENTO){content = livro.getAnoLancamento();}
        if(col == COL_GENERO){content = livro.getGenero();}
        
        return content;
    }
}