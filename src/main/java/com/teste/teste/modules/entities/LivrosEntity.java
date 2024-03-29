package com.teste.teste.modules.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "LIVROS_CONSULT")
public class LivrosEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(updatable = false)
    private int codigo;

    @Column(length = 30, nullable = false, unique = true)
    private String nome;


    @Column(length = 4, nullable = false)
    private double preco;


    @JsonFormat(pattern = "dd.MM.YYYY HH:mm")
    private Timestamp creatAt;

    @ManyToOne
    @JoinColumn(name = "fk_categorias")
    @JsonBackReference // ESTUDAR ISSO
    private CategoriaEntity categoriaEntity;

    private Boolean Status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Timestamp getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Timestamp creatAt) {
        this.creatAt = creatAt;
    }

    public CategoriaEntity getCategoriaEntity() {
        return categoriaEntity;
    }

    public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
        this.categoriaEntity = categoriaEntity;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }
}
