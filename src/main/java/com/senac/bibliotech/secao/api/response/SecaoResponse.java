package com.senac.bibliotech.secao.api.response;

public record SecaoResponse(
        Long id,
        String nome,
        String descricao,
        String localizacao
) {
}
