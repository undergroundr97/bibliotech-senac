package com.senac.bibliotech.livro.mapper;


import com.senac.bibliotech.categoria.api.response.CategoriaResponse;
import com.senac.bibliotech.livro.api.request.LivroRequest;
import com.senac.bibliotech.livro.api.response.LivroResponse;
import com.senac.bibliotech.livro.domain.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
        componentModel = "spring",
    uses = CategoriaResponse.class)
public interface LivroMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "autor", ignore = true)
    @Mapping(target = "categoria", ignore = true)
    Livro createLivro(LivroRequest livroRequest);


    LivroResponse toResponse(Livro livro);
}
