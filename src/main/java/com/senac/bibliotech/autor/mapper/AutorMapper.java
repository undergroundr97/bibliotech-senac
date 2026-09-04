package com.senac.bibliotech.autor.mapper;


import com.senac.bibliotech.autor.api.request.AutorRequest;
import com.senac.bibliotech.autor.domain.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    void updateAutor(AutorRequest autorRequest, @MappingTarget Autor autor);
    Autor toAutor(AutorRequest autorRequest);
}
