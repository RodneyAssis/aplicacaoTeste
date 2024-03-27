package com.teste.teste.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class LivrosDTO {

    @NotBlank
    @Size(max = 20)
    private String nome;

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


//    public String getFile() {
//        return file;
//    }
}
