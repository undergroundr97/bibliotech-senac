package com.senac.bibliotech.livro.service;


import com.senac.bibliotech.autor.domain.Autor;
import com.senac.bibliotech.autor.repository.AutorRepository;
import com.senac.bibliotech.autor.service.AutorService;
import com.senac.bibliotech.categoria.api.request.CategoriaRequest;
import com.senac.bibliotech.categoria.model.Categoria;
import com.senac.bibliotech.categoria.repository.CategoriaRepository;
import com.senac.bibliotech.categoria.service.CategoriaService;
import com.senac.bibliotech.livro.api.request.LivroRequest;
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

}
