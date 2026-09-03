package com.senac.bibliotech.restcontroller;


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
    public ResponseEntity<Autor> postAutor(@RequestBody )
}
