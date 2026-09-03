package com.senac.bibliotech.mapper;


import com.senac.bibliotech.dto.AutorRequest;
import com.senac.bibliotech.model.Autor;
import com.senac.bibliotech.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    void updateAutor(AutorRequest autorRequest, @MappingTarget Autor autor);
    Autor toAutor(AutorRequest autorRequest);
}
