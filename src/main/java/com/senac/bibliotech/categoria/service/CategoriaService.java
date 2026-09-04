package com.senac.bibliotech.categoria.service;

import com.senac.bibliotech.categoria.api.request.CategoriaRequest;
import com.senac.bibliotech.categoria.api.request.CategoriaResponse;
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


    public Categoria findCategoriaEntityById(Long id){
        return categoriaRepository
                .findById(id)
                .orElseThrow();

    }

    public CategoriaResponse findCategoriaById(Long id){
        Categoria categoria = findCategoriaEntityById(id);
        return categoriaMapper.toResponse(categoria);
    }

    public List<CategoriaResponse> findAllCategorias(){
        return categoriaRepository
                .findAll()
                .stream()
                .map(categoriaMapper::toResponse)
                .toList();
    }

    public CategoriaResponse saveCategoria(CategoriaRequest categoriaRequest){
        Categoria categoria = categoriaMapper.toCategoria(categoriaRequest);

        Categoria categoriaSaved = categoriaRepository.save(categoria);

        return categoriaMapper.toResponse(categoriaSaved);
    }

    public CategoriaResponse updateCategoria(Long id, CategoriaRequest categoriaRequest){
        Categoria categoria = findCategoriaEntityById(id);
        categoriaMapper.updateCategoria(categoriaRequest, categoria);
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        return categoriaMapper.toResponse(categoriaSalva);

    }

    public void deleteCategoriaById(Long id){
        Categoria categoria = findCategoriaEntityById(id);
        categoriaRepository.deleteById(id);
    }


}
