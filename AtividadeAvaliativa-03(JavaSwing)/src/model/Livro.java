/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno.lab
 */
public class Livro {
    private int id;
    private String nome;
    private String autor;
    private int qtdPaginas;
    private int anoLancamento;
    private String genero;

    /*Getters e Setters*/
    // id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // nome do livro
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // autor do livro
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // quantidade de páginas do livro
    public int getQtdPaginas() {
        return qtdPaginas;
    }
    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    // ano de lançamento do livro
    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    // gênero do livro
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}