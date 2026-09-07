package com.senac.bibliotech.secao.api.request;

import jakarta.validation.constraints.NotBlank;

public record SecaoRequest(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String localizacao
) {
}
