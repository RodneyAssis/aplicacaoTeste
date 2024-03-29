package com.teste.teste.modules.repositories;

import com.teste.teste.modules.entities.LivrosEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository // Identificar que essa interface é um repository
public interface ILivrosRepository extends JpaRepository<LivrosEntity, UUID> {
    boolean existsByNome(String nome);

    void deleteById(UUID uuid);

    Optional<LivrosEntity> findByCodigo(int code);

    @Query("SELECT COUNT (*) FROM LivrosEntity")
    int ContadorLivros();
}
