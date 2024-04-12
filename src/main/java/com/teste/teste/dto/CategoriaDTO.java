package com.teste.teste.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaDTO {

    @JsonIgnore
    private int codigoCategoria;

    @NotBlank
    @Size(min = 3, max = 50, message = "O nome da categoria deve possui entre {min} e {max} caracteres.")
    private String nomeCategoria;

    @JsonIgnore
    public int getCodigo() {
        return codigoCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }


}
