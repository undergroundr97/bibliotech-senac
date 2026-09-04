package com.senac.bibliotech.categoria.api;


import com.senac.bibliotech.categoria.api.request.CategoriaResponse;
import com.senac.bibliotech.categoria.model.Categoria;
import com.senac.bibliotech.categoria.service.CategoriaService;
import org.mapstruct.MappingTarget;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@MappingTarget("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        return ResponseEntity.ok(categoriaService.findAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> getCategoriaById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findCategoriaById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse>

}
