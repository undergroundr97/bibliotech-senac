package com.senac.bibliotech.restcontroller;


import com.senac.bibliotech.dto.AutorRequest;
import com.senac.bibliotech.model.Autor;
import com.senac.bibliotech.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorRestController {

    private final AutorService autorService;

    public AutorRestController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutor(){
        return ResponseEntity.ok(autorService.findAll());
    }

    @PostMapping
    public ResponseEntity<Autor> postAutor(@RequestBody AutorRequest autorRequest){
        return ResponseEntity.ok(autorService.saveAutor(autorRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id){
        if(autorService.existsById(id)){
            Autor autor = autorService.findById(id).orElseThrow();
            return ResponseEntity.ok(autor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutorById(@PathVariable Long id){
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public ResponseEntity<Autor> patchAutor(@RequestBody AutorRequest autorRequest){
        autorService.
    }
}
