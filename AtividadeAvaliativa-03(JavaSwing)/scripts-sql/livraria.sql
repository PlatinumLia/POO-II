CREATE DATABASE db_livraria;

CREATE TABLE tb_livros(
    codigo INT(4) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    autor VARCHAR(80) NOT NULL,
    qtd_paginas INT NOT NULL,
    ano_lancamento INT NOT NULL,
    genero VARCHAR(80) NOT NULL,
    PRIMARY KEY(codigo)
);