package com.senac.bibliotech.biblioteca.api.response;

public record BibliotecaResponse(
        Long id,
        String nome,
        String endereco,
        String telefone,
        String email
) {
}
