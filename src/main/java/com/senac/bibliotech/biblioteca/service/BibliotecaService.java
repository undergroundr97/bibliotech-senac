package com.senac.bibliotech.biblioteca.service;

import com.senac.bibliotech.biblioteca.api.request.BibliotecaRequest;
import com.senac.bibliotech.biblioteca.api.response.BibliotecaResponse;
import com.senac.bibliotech.biblioteca.mapper.BibliotecaMapper;
import com.senac.bibliotech.biblioteca.model.Biblioteca;
import com.senac.bibliotech.biblioteca.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;
    private final BibliotecaMapper bibliotecaMapper;


    public BibliotecaService(BibliotecaRepository bibliotecaRepository, BibliotecaMapper bibliotecaMapper) {
        this.bibliotecaRepository = bibliotecaRepository;
        this.bibliotecaMapper = bibliotecaMapper;
    }

    private Biblioteca findBibliotecaEntityById(Long id){
        return bibliotecaRepository.findById(id)
                .orElseThrow();
    }

    public BibliotecaResponse findBibliotecaById(Long id){
        return bibliotecaMapper.toResponse(findBibliotecaEntityById(id));
    }

    public List<BibliotecaResponse> findAllBibliotecas(){
        return bibliotecaRepository.findAll()
                .stream()
                .map(bibliotecaMapper::toResponse)
                .toList();
    }

    public void deleteBibliotecaById(Long id){
        Biblioteca biblioteca = findBibliotecaEntityById(id);
        bibliotecaRepository.delete(biblioteca);
    }

    public BibliotecaResponse saveBiblioteca(BibliotecaRequest bibliotecaRequest){
        Biblioteca biblioteca = bibliotecaMapper.createBiblioteca(bibliotecaRequest);

        Biblioteca savedBiblioteca = bibliotecaRepository.save(biblioteca);
        return bibliotecaMapper.toResponse(savedBiblioteca);
    }





}
