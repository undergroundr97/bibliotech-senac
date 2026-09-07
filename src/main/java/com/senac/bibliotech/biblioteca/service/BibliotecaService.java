package com.senac.bibliotech.biblioteca.service;

import com.senac.bibliotech.biblioteca.api.response.BibliotecaResponse;
import com.senac.bibliotech.biblioteca.mapper.BibliotecaMapper;
import com.senac.bibliotech.biblioteca.model.Biblioteca;
import com.senac.bibliotech.biblioteca.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;
    private final BibliotecaMapper bibliotecaMapper;


    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    private Biblioteca findBibliotecaEntityById(Long id){
        return bibliotecaRepository.findById(id)
                .orElseThrow();
    }

    public BibliotecaResponse findBibliotecaById(Long id){
        return bibliotecaMapper.toResponse(findBibliotecaEntityById(id));
    }

    2


}
