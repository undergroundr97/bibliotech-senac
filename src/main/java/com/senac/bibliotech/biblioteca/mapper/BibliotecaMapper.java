package com.senac.bibliotech.biblioteca.mapper;

import com.senac.bibliotech.biblioteca.api.response.BibliotecaResponse;
import com.senac.bibliotech.biblioteca.model.Biblioteca;

public interface BibliotecaMapper {

    BibliotecaResponse toResponse(Biblioteca biblioteca);

}
