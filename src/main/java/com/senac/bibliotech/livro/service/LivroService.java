package com.senac.bibliotech.livro.service;


import com.senac.bibliotech.autor.domain.Autor;
import com.senac.bibliotech.autor.service.AutorService;
import com.senac.bibliotech.categoria.model.Categoria;
import com.senac.bibliotech.categoria.service.CategoriaService;
import com.senac.bibliotech.livro.api.request.LivroPatchRequest;
import com.senac.bibliotech.livro.api.request.LivroRequest;
import com.senac.bibliotech.livro.api.response.LivroResponse;
import com.senac.bibliotech.livro.domain.Livro;
import com.senac.bibliotech.livro.mapper.LivroMapper;
import com.senac.bibliotech.livro.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final LivroMapper livroMapper;
    private final AutorService autorService;
    private final CategoriaService categoriaService;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper, AutorService autorService, CategoriaService categoriaService) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
        this.autorService = autorService;
        this.categoriaService = categoriaService;
    }


    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro save(LivroRequest livroRequest){
        Autor autor = autorService.findById(livroRequest.autorId());
        Categoria categoria = categoriaService.findCategoriaEntityById(livroRequest.categoriaId());

        Livro livro = livroMapper.createLivro(livroRequest);
        livro.setAutor(autor);
        livro.setCategoria(categoria);

        return livroRepository.save(livro);
    }


    public Livro findLivroEntityById(Long id){
        return livroRepository
                .findById(id)
                .orElseThrow();
    }
    public LivroResponse findLivroById(Long id){
        Livro livro = findLivroEntityById(id);
        return livroMapper.toResponse(livro);
    }

    public void deleteLivroById(Long id){
        Livro livro = findLivroEntityById(id);
        livroRepository.delete(livro);
    }

    public LivroResponse putLivro(Long id, LivroRequest livroRequest){
        Livro livro = findLivroEntityById(id);
        livroMapper.putLivro(livroRequest, livro);

        Autor autor = autorService.findById(livroRequest.autorId());
        Categoria categoria = categoriaService.findCategoriaEntityById(livroRequest.categoriaId());

        livro.setAutor(autor);
        livro.setCategoria(categoria);


        Livro savedLivro = livroRepository.save(livro);

        return livroMapper
                .toResponse(savedLivro);


    }


    public LivroResponse patchLivro(Long id, LivroPatchRequest livroPatchRequest) {
        Livro livro = findLivroEntityById(id);
        if (livroPatchRequest.autorId() != null) {
            livro.setAutor(autorService.findById(livroPatchRequest.autorId()));
        }
        if (livroPatchRequest.categoriaId() != null) {
            livro.setCategoria(categoriaService.findCategoriaEntityById(livroPatchRequest.categoriaId()));
        }
        livroMapper.patchLivro(livroPatchRequest, livro);
        Livro savedLivro = livroRepository.save(livro);

        return livroMapper
                .toResponse(savedLivro);

    }
}
