package com.senac.bibliotech.categoria.api.request;

public record CategoriaPatchRequest(
        String nome,
        String descricao
) {
}
