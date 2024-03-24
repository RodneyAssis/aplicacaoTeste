package com.teste.teste.modules.repositories;

import com.teste.teste.modules.entities.LivrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // Identificar que essa interface é um repository
public interface ILivrosRepository extends JpaRepository<LivrosEntity, UUID> {
    boolean existsByNome(String nome);

    void deleteById(UUID id);


}
