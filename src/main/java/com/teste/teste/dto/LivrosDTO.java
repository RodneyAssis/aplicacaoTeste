package com.teste.teste.dto;

import jakarta.validation.constraints.*;

import java.util.Locale;


public class LivrosDTO {


    @NotBlank
    @NotNull
    private int codigo;

    @NotBlank
    @Size(max = 20)
    private String nome;

    private String categoria;

    @Max(1000)
    @Min(0)
    private double preco;

//    private String file;


    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getCodigo() {
        return codigo+1;
    }

    public String getCategoria() {
        return categoria;
    }

    //    public String getFile() {
//        return file;
//    }
}
