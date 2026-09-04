package com.senac.bibliotech.categoria.api;


import com.senac.bibliotech.categoria.api.request.CategoriaRequest;
import com.senac.bibliotech.categoria.api.response.CategoriaResponse;
import com.senac.bibliotech.categoria.service.CategoriaService;
import jakarta.validation.Valid;
import org.mapstruct.MappingTarget;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestControllerAdvice
@MappingTarget("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> getAllCategorias(){
        return ResponseEntity.ok(categoriaService.findAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> getCategoriaById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findCategoriaById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> postCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest){

        CategoriaResponse categoriaResponse = categoriaService.saveCategoria(categoriaRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaResponse.id())
                .toUri();

        return ResponseEntity.created(uri).body(categoriaResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> putCategoria(@PathVariable Long id,
                                                          @Valid @RequestBody CategoriaRequest categoriaRequest){
        return ResponseEntity.ok(categoriaService.updateCategoria(id, categoriaRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoriaResponse> patchCategoria(@PathVariable Long id,
                                                            @Valid @RequestBody CategoriaRequest categoriaRequest){

    }

}
