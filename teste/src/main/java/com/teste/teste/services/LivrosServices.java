package com.teste.teste.services;


import com.teste.teste.modules.entities.LivrosEntity;
import com.teste.teste.modules.repositories.ILivrosRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LivrosServices {

    final ILivrosRepository iLivrosRepository;

    public LivrosServices(ILivrosRepository iLivrosRepository) {
        this.iLivrosRepository = iLivrosRepository;
    }

    @Transactional // Caso algo dê errado ele fara um rouback ou dados quebrados
    public LivrosEntity save(LivrosEntity livrosEntity) {
        return iLivrosRepository.save(livrosEntity);
    }

    public boolean existeLivro(String livrosDTONome) {
        return iLivrosRepository.existsByNome(livrosDTONome);
    }


    public List<LivrosEntity> findAllLivros() {
        return iLivrosRepository.findAll();
    }

    public Optional<LivrosEntity> findbyID(UUID id) {
        return iLivrosRepository.findById(id);
    }

    @Transactional
    public void deletedID(UUID id) {
        iLivrosRepository.deleteById(id);
    }

    @Transactional
    public void deletaAll() {
        iLivrosRepository.deleteAll();
    }


}
