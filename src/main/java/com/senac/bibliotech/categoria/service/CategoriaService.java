package com.senac.bibliotech.categoria.service;

import com.senac.bibliotech.categoria.api.request.CategoriaRequest;
import com.senac.bibliotech.categoria.mapper.CategoriaMapper;
import com.senac.bibliotech.categoria.model.Categoria;
import com.senac.bibliotech.categoria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;


    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }


    public Categoria findCategoriaById(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow();
    }

    public List<Categoria> findAllCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria saveCategoria(CategoriaRequest categoriaRequest){

        Categoria categoria = categoriaMapper.toCategoria(categoriaRequest);
        return categoriaRepository.save(categoria);

    }

    public Categoria updateCategoria(Long id, CategoriaRequest categoriaRequest){
        Categoria categoria = findCategoriaById(id);
        categoriaMapper.updateCategoria(categoriaRequest, categoria);
        return categoriaRepository.save(categoria);
    }

    public void deleteCategoriaById(Long id){
        Categoria categoria = findCategoriaById(id);
        categoriaRepository.deleteById(id);
    }


}
