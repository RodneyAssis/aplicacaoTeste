package com.teste.teste.services;

import com.teste.teste.modules.entities.CategoriaEntity;
import com.teste.teste.modules.repositories.ICategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {
    final ICategoriaRepository iCategoriaRepository;
    public CategoriaServices(ICategoriaRepository iCategoriaRepository) {
        this.iCategoriaRepository = iCategoriaRepository;
    }

    public boolean Existe(String nomeCategoria) {
        return iCategoriaRepository.existsByNomeCategoria(nomeCategoria);
    }


    public Object save(CategoriaEntity categoriaEntity) {
        return iCategoriaRepository.save(categoriaEntity);
    }

    public int cont(){
        return iCategoriaRepository.contadorCategoria()+1;
    }

    public Optional<CategoriaEntity> findByName(String nome) {
        return iCategoriaRepository.findByNomeCategoria(nome);
    }

    public List<CategoriaEntity> findAllCategorias() {
        return iCategoriaRepository.findAll();
    }
}
