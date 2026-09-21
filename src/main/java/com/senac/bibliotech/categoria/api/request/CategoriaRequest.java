package com.senac.bibliotech.categoria.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CategoriaRequest(
        @NotBlank
        String nome,
        @NotBlank
        String descricao
) {
}
