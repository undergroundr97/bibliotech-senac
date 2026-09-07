package com.senac.bibliotech.biblioteca.api;


import com.senac.bibliotech.biblioteca.api.request.BibliotecaRequest;
import com.senac.bibliotech.biblioteca.api.response.BibliotecaResponse;
import com.senac.bibliotech.biblioteca.model.Biblioteca;
import com.senac.bibliotech.biblioteca.service.BibliotecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {


    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @GetMapping
    public ResponseEntity<List<BibliotecaResponse>> getAllBiblioteca(){
        return ResponseEntity.ok(bibliotecaService.findAllBibliotecas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BibliotecaResponse> getBibliotecaById(@PathVariable Long id){
        return ResponseEntity.ok(bibliotecaService.findBibliotecaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiblioteca(@PathVariable Long id){
        bibliotecaService.deleteBibliotecaById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<BibliotecaResponse> saveBiblioteca(@RequestBody BibliotecaRequest bibliotecaRequest){
        BibliotecaResponse createdLib = bibliotecaService.saveBiblioteca(bibliotecaRequest);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdLib)
                .toUri();

        return ResponseEntity.created(uri).body(createdLib);
    }



}
