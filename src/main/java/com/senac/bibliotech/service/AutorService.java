package com.senac.bibliotech.service;

import com.senac.bibliotech.dto.AutorRequest;
import com.senac.bibliotech.mapper.AutorMapper;
import com.senac.bibliotech.model.Autor;
import com.senac.bibliotech.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    public AutorService(AutorRepository autorRepository, AutorMapper autorMapper) {
        this.autorRepository = autorRepository;
        this.autorMapper = autorMapper;
    }


    public List<Autor> findAll(){
        return autorRepository.findAll();
    }

    public Autor findById(Long id){
        return autorRepository
                .findById(id)
                .orElseThrow();
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

    public Autor updateAutor(Long id, AutorRequest autorRequest){
        Autor autor = findById(id);
        autorMapper.updateAutor(autorRequest, autor);
        return autorRepository.save(autor);

    }

}
