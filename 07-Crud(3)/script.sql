CREATE DATABASE db_locadora

CREATE TABLE tb_veiculos(  
    codigo int(4) NOT NULL AUTO_INCREMENT,
    marca VARCHAR(30) NOT NULL,
    modelo VARCHAR(40) NOT NULL,
    chassi VARCHAR(30) NOT NULL,
    ano INT(4) NOT NULL,
    PRIMARY KEY(codigo)
);