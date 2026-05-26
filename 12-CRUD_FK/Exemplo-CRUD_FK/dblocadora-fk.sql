mysql -u root -p 'bancodedados'

create database dblocadora;
use dblocadora;

create table tb_veiculos(
    codigo INT(4) NOT NULL AUTO_INCREMENT, 
    marca VARCHAR(30) NOT NULL, 
    modelo VARCHAR(40) NOT NULL, 
    chassi VARCHAR(30) NOT NULL, 
    ano INT(4) NOT NULL, 
    primary key(codigo)
);

show tables;
select * from tb_veiculos;

create table tb_clientes_pj(
    cod_cli_pj INT(4) NOT NULL AUTO_INCREMENT, 
    nome VARCHAR(30) NOT NULL, 
    cnpj VARCHAR(20) NOT NULL, 
    primary key(cod_cli_pj)
);

create table tb_enderecos_pj(
    cod_end INT(4) NOT NULL AUTO_INCREMENT, 
    cod_cli_pj INT(4) NOT NULL, 
    rua VARCHAR(30), 
    numero INT(5), 
    bairro VARCHAR(30), 
    cep VARCHAR(10), 
    PRIMARY KEY(cod_end), 
    FOREIGN KEY(cod_cli_pj) REFERENCES tb_clientes_pj(cod_cli_pj));