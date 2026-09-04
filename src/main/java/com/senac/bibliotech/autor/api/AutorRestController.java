package com.senac.bibliotech.autor.api;


import com.senac.bibliotech.autor.api.request.AutorRequest;
import com.senac.bibliotech.autor.domain.Autor;
import com.senac.bibliotech.autor.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

        Autor savedAutor = autorService.saveAutor(autorRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedAutor)
                .toUri();

        return ResponseEntity.created(uri).body(savedAutor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id){
        return ResponseEntity.ok(autorService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutorById(@PathVariable Long id){
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Autor> patchAutor(@PathVariable Long id,
                                            @RequestBody AutorRequest autorRequest){
        return ResponseEntity.ok(autorService.updateAutor(id, autorRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> putAutor(@PathVariable Long id,
                                          @RequestBody AutorRequest autorRequest){
        return ResponseEntity.ok(autorService.updateAutor(id, autorRequest));
    }
}
