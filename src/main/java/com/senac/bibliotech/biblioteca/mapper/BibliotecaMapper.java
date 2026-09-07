package com.senac.bibliotech.biblioteca.mapper;

import com.senac.bibliotech.biblioteca.api.request.BibliotecaRequest;
import com.senac.bibliotech.biblioteca.api.response.BibliotecaResponse;
import com.senac.bibliotech.biblioteca.model.Biblioteca;
import org.mapstruct.Mapping;

public interface BibliotecaMapper {

    BibliotecaResponse toResponse(Biblioteca biblioteca);

    @Mapping(target = "id", ignore = true)
    Biblioteca createBiblioteca(BibliotecaRequest bibliotecaRequest);

}
