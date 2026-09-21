package com.senac.bibliotech.usuario.api.response;

public record UsuarioResponse(
        Long id,
        String nome,
        String email
) {
}
