package com.senac.bibliotech.usuario.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email
) {
}
