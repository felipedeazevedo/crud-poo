create schema crud_poo;

CREATE TABLE Autor (
                       id int NOT NULL AUTO_INCREMENT,
                       nome varchar(50) NOT NULL,
                       endereco varchar(150) NOT NULL,
                       idade int,
                       PRIMARY KEY (id)
);

CREATE TABLE Livro (
                       id int NOT NULL AUTO_INCREMENT,
                       nome varchar(50) NOT NULL,
                       autor_id int NOT NULL,
                       editora varchar(50) NOT NULL,
                       qtd_paginas int,
                       genero varchar(30),
                       PRIMARY KEY (id),
                       FOREIGN KEY (autor_id) REFERENCES Autor(id)
);