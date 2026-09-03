package com.senac.bibliotech.service;

import com.senac.bibliotech.dto.AutorRequest;
import com.senac.bibliotech.model.Autor;
import com.senac.bibliotech.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    public List<Autor> findAll(){
        return autorRepository.findAll();
    }

    public Optional<Autor> findById(Long id){
        return autorRepository.findById(id);
    }

    public Autor saveAutor(AutorRequest autorRequest){
        Autor autor = new Autor(null, autorRequest.nome());
        return autorRepository.save(autor);
    }

    public void deleteAutor(Long id){
        autorRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return autorRepository.existsById(id);
    }

}
