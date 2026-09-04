package com.senac.bibliotech.livro.service;


import com.senac.bibliotech.livro.domain.Livro;
import com.senac.bibliotech.livro.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;


    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

//    public Livro save(LivroRequest livroRequest){
//
//
//    }

}
