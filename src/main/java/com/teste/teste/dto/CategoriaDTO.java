package com.teste.teste.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoriaDTO {


    @NotBlank
    @NotNull
    private int codigo;

    @NotBlank
    @NotNull
    private String nome_Categoria;

    @Min(0)
    private int codigo_Categoria;

//    List<LivrosEntity> livrosEntities;


    public int getCodigo() {
        return codigo;
    }

    public String getNome_Categoria() {
        return nome_Categoria;
    }

    public int getCodigo_Categoria() {
        return codigo_Categoria;
    }

//    public List<LivrosEntity> getLivrosEntities() {
//        return livrosEntities;
//    }


}
