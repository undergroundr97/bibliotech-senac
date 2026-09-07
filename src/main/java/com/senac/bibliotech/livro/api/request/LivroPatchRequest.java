package com.senac.bibliotech.livro.api.request;

public record LivroPatchRequest(
        String titulo,
        String isbn,
        Long autorId,
        Long categoriaId
) {
}
