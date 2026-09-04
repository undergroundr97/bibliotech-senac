package com.senac.bibliotech.categoria.api.request;

public record CategoriaResponse(
        Long id,
        String nome,
        String descricao
) {
}
