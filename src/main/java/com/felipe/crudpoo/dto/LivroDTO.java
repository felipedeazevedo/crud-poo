package com.felipe.crudpoo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDTO {
    private Integer id;
    private String nome;
    private Integer autorId;
    private String editora;
    private Integer qtdPaginas;
    private String genero;
}
