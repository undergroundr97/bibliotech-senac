package com.senac.bibliotech.livro.api.response;

public record LivroResumeResponse(
        Long id,
        String titulo,
        String isbn
) {
}
