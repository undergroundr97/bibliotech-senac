package com.senac.bibliotech.livro.api;


import com.senac.bibliotech.livro.domain.Livro;
import com.senac.bibliotech.livro.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroRestController {


    private final LivroService livroService;

    public LivroRestController(LivroService livroService) {
        this.livroService = livroService;
    }


    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros(){
        return ResponseEntity.ok(livroService.findAll());
    }

//    @PostMapping
//    public ResponseEntity<Livro> postLivr(
//            @Valid
//            @RequestBody
//            LivroRequest livroRequest){
//
//    }

}
