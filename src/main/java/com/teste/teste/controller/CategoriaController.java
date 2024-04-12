package com.teste.teste.controller;


import com.teste.teste.dto.CategoriaDTO;
import com.teste.teste.modules.entities.CategoriaEntity;
import com.teste.teste.services.CategoriaServices;
import com.teste.teste.services.LivrosServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 4000)
@RequestMapping("/categoria")
public class CategoriaController {

    final CategoriaServices categoriaServices;
    final LivrosServices livrosServices;

    public CategoriaController(CategoriaServices categoriaServices, LivrosServices livrosServices) {
        this.categoriaServices = categoriaServices;
        this.livrosServices = livrosServices;
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Base de dados registrado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Falha ao registrar a categoria na base de dados," +
                            "favor entrar em contato com o administrador.")
            }
    )
    @PostMapping
    public ResponseEntity<Object> createCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO,
                                                  BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            List<String> errorValidacao = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorValidacao.add(error.getField() + ":" + error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorValidacao);
        }

//        Verificar se já existe a categoria registrado na base de dados
        if (categoriaServices.Existe(categoriaDTO.getNomeCategoria())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("A categoria já " +
                    categoriaDTO.getNomeCategoria() + " já existe na base de dados.");
        }



        var categoriaEntity = new CategoriaEntity();
        categoriaEntity.setCodigoCategoria(categoriaServices.cont());
        categoriaEntity.setNomeCategoria(categoriaDTO.getNomeCategoria());


        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaServices.save(categoriaEntity));
    }

    @Operation(description = "Listar todas categorias registradas e livros dessa mesma categoria.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Categorias e livros do mesmo exibidos com sucesso.")
    }
    )
    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> listResponseEntity(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoriaServices.findAllCategorias());
    }

    @Operation(description = "Sincronizar filme com uma categoria desejada (Não está pronto)")
    @PostMapping("/link")
    public ResponseEntity<Object> linkLivroCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO){
        var livro = livrosServices.findbyCode(categoriaDTO.getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }
}
