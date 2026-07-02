-- Active: 1773959692019@@127.0.0.1@3306@db_compendium
CREATE DATABASE db_compendium;

CREATE TABLE tb_demons(
    id INT(4) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    nivel INT NOT NULL,
    fraqueza VARCHAR(80) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE tb_users(
    id INT(4) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    nivel INT NOT NULL,
    invocacao VARCHAR(80) NOT NULL,
    PRIMARY KEY(id)
);

/* Insert's para teste*/
INSERT INTO tb_demons(nome, nivel, fraqueza) VALUES
('Arsène', 75, 'BLESS');

INSERT INTO tb_users(nome, nivel, invocacao) VALUES
('Ren Amamiya', 80, 'MASK')