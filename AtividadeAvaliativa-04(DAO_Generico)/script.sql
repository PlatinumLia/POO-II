-- Active: 1773959692019@@127.0.0.1@3306@demon_compendium
CREATE DATABASE demon_compendium;

CREATE TABLE demon(
    id_demon INT(4) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    nivel INT NOT NULL,
    raca VARCHAR(80) NOT NULL,
    fraqueza VARCHAR(80) NOT NULL,
    PRIMARY KEY(id_demon)
);

CREATE TABLE demon_user(
    id_demon_user INT(4) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    tipo_invocacao VARCHAR(80) NOT NULL,
    id_demonio INT NOT NULL REFERENCES demon(id_demon),
    PRIMARY KEY(id_demon_user)
);