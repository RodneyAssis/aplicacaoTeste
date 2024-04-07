package com.teste.teste.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class LivrosDTO {

    @JsonIgnore
    private int codigo;

    @NotBlank(message = "Nome é obrigatorio.")
    @Length(min = 3, max = 35, message = "O nome deve ter entre {min} e {max} caracteres.")
    private String nome;

    private String categoria;

    @Min(value = 5, message = "Preço não pode ser menor que 5")
    @Max(value = 10000, message = "Compras não pode não pode ser maior quê 10,000")
    private Double preco;

//    private String file;


    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getPreco() {
        return preco;
    }

    @JsonIgnore
    public int getCodigo() {
        return codigo+1;
    }

}
