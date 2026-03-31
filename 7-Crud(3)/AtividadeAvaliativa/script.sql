CREATE DATABASE db_locadora

CREATE TABLE tb_veiculos(  
    codigo int(4) NOT NULL AUTO_INCREMENT,
    marca VARCHAR(30) NOT NULL,
    modelo VARCHAR(40) NOT NULL,
    chassi VARCHAR(30) NOT NULL,
    ano INT(4) NOT NULL,
    PRIMARY KEY(codigo)
);

CREATE TABLE tb_vendedor(
    codigo SERIAL PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    cpf VARCHAR(13) NOT NULL,
    telefone VARCHAR(12) NOT NULL,
    estadoCivil VARCHAR(10) NOT NULL CHECK('casado', 'solteiro', 'divorciado')
);