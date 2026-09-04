package com.senac.bibliotech.restcontroller;


import com.senac.bibliotech.dto.LivroRequest;
import com.senac.bibliotech.model.Livro;
import com.senac.bibliotech.repository.LivroRepository;
import com.senac.bibliotech.service.LivroService;
import jakarta.validation.Valid;
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
