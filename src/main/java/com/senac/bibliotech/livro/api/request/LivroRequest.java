package com.senac.bibliotech.livro.api.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LivroRequest(
        @NotNull
        String titulo,
        @NotNull
        String isbn,
        @Positive
        @NotNull
        Long autorId
) {
}
