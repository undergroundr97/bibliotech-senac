package com.senac.bibliotech.livro.api.response;

import com.senac.bibliotech.autor.domain.Autor;
import com.senac.bibliotech.categoria.model.Categoria;

public record LivroResponse (
        Long id,
        String titulo,
        String isbn,
        Autor autor,
        Categoria categoria){
}
