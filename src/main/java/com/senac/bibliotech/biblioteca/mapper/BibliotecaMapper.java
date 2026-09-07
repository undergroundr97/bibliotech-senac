package com.senac.bibliotech.biblioteca.mapper;

import com.senac.bibliotech.biblioteca.api.request.BibliotecaRequest;
import com.senac.bibliotech.biblioteca.api.response.BibliotecaResponse;
import com.senac.bibliotech.biblioteca.model.Biblioteca;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BibliotecaMapper {

    BibliotecaResponse toResponse(Biblioteca biblioteca);

    @Mapping(target = "id", ignore = true)
    Biblioteca createBiblioteca(BibliotecaRequest bibliotecaRequest);

}
