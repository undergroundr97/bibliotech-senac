package com.senac.bibliotech.autor.service;

import com.senac.bibliotech.autor.api.request.AutorRequest;
import com.senac.bibliotech.autor.mapper.AutorMapper;
import com.senac.bibliotech.autor.domain.Autor;
import com.senac.bibliotech.autor.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
