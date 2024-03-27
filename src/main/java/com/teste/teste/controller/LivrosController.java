package com.teste.teste.controller;

import com.teste.teste.dto.LivrosDTO;
import com.teste.teste.modules.entities.LivrosEntity;
import com.teste.teste.services.LivrosServices;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livros")
public class LivrosController {

    final
    LivrosServices livrosServices;

    public LivrosController(LivrosServices livrosServices) {
        this.livrosServices = livrosServices;
    }


    @PostMapping
    public ResponseEntity<Object> saveLivros(@RequestBody @Valid LivrosDTO livrosDTO){
        if (livrosServices.existeLivro(livrosDTO.getNome())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Nome/ID já registrado");
        }
        var livrosEntity = new LivrosEntity();
        BeanUtils.copyProperties(livrosDTO, livrosEntity);
        Timestamp teste = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC-3")));
        livrosEntity.setCreatAt(teste);

        return ResponseEntity.status(HttpStatus.CREATED).body(livrosServices.save(livrosEntity));
    }

    @GetMapping
    public ResponseEntity<List<LivrosEntity>> viewLivros(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosServices.findAllLivros());
    }

    @GetMapping("/{id}")
    public Optional<LivrosEntity> viewForID(@PathVariable(value = "id") UUID id){
        var result = livrosServices.findbyID(id);
        if (result.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não encontrado ou produto não existe");
            return result;
        }


//        return ResponseEntity.status(HttpStatus.OK).body(result.get());
        return result;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteForID(@PathVariable(value = "id") UUID id){
        var result = livrosServices.findbyID(id);
        if (result.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não encontrado ou produto não existe");
        }

        livrosServices.deletedID(id);

        return ResponseEntity.status(HttpStatus.OK).body("Livro " + result.get().getNome() + " deletado com sucesso!");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivro(@RequestBody @Valid LivrosDTO livrosDTO,
                                              @PathVariable(value = "id") UUID id){
        var consultaPorID = livrosServices.findbyID(id);
        if (consultaPorID.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro com o id: " + id + " não encontrado.");
        }

        var livrosEntity = consultaPorID.get();
        livrosEntity.setNome(livrosDTO.getNome());
        livrosEntity.setPreco(livrosDTO.getPreco());

        Timestamp teste = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC-6")));
        livrosEntity.setCreatAt(teste);
        livrosServices.save(livrosEntity);

//        Metodo alternativo
//        BeanUtils.copyProperties(livrosDTO, livrosEntity);
//        livrosEntity.setId(consultaPorID.get().getId());


        return ResponseEntity.status(HttpStatus.OK).body("Alterações efetuadas com sucesso");

    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> addFoto(@RequestBody LivrosDTO livrosDTO, @PathVariable(name = "id") UUID id){
//
//        return ResponseEntity.status(HttpStatus.OK).body("Imagens adicionadas com sucesso.");
//    }


    @DeleteMapping("/byebye")
    public ResponseEntity<Object> DELETATUDOOO(){
        livrosServices.deletaAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("ACEITO: Tudo deletado");
    }

}
