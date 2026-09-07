package com.senac.bibliotech.exemplar.api.request;

public record ExemplarRequest(
        String codigoPatrimonio,
        Long livroId,
        Long secaoId
) {
}
