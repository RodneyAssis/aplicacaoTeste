package com.teste.teste.modules.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
public class CategoriaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idCategoria;

    @Column(updatable = false)
    private int codigoCategoria;

    @Column(unique = true)
    private String nomeCategoria;

    @JsonManagedReference
    @OneToMany(mappedBy = "categoriaEntity")
    List<LivrosEntity> livrosEntities;

    public UUID getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(UUID idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public List<LivrosEntity> getLivrosEntities() {
        return livrosEntities;
    }

    public void setLivrosEntities(List<LivrosEntity> livrosEntities) {
        this.livrosEntities = livrosEntities;
    }
}