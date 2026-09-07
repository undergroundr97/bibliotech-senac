package com.senac.bibliotech.livro.api;


import com.senac.bibliotech.livro.api.request.LivroPatchRequest;
import com.senac.bibliotech.livro.api.request.LivroRequest;
import com.senac.bibliotech.livro.api.response.LivroResponse;
import com.senac.bibliotech.livro.domain.Livro;
import com.senac.bibliotech.livro.service.LivroService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {


    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }


    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros(){
        return ResponseEntity.ok(livroService.findAll());
    }

    @PostMapping
    public ResponseEntity<Livro> postLivr(
            @Valid
            @RequestBody
            LivroRequest livroRequest){

        Livro livro = livroService.save(livroRequest);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livro)
                .toUri();

        return ResponseEntity.created(uri).body(livro);

    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> getLivroById(
            @PathVariable Long id){
        return ResponseEntity.ok(livroService.findLivroById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLivroById(
            @PathVariable Long id){
        livroService.deleteLivroById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> putLivro(@PathVariable Long id,
                                                    @Valid @RequestBody LivroRequest livroRequest){

        return ResponseEntity.ok(livroService.putLivro(id, livroRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LivroResponse> patchLivro(
            @PathVariable Long id,
            @RequestBody LivroPatchRequest livroPatchRequest
            ){
        return ResponseEntity.ok(livroService.patchLivro(id, livroPatchRequest));
    }

}
