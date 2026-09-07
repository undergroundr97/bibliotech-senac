package com.senac.bibliotech.biblioteca.api.request;

public record BibliotecaRequest(
        String nome,
        String endereco,
        String telefone,
        String email
) {
}
