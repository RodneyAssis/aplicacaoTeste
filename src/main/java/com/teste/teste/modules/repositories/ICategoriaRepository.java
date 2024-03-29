package com.teste.teste.modules.repositories;

import com.teste.teste.modules.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, UUID> {
    boolean existsByNomeCategoria(String string);
    Optional<CategoriaEntity> findByNomeCategoria(@Param("nome") String nome);

    @Query("select count(*) from CategoriaEntity")
    int contadorCategoria();

}
