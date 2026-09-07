package com.senac.bibliotech.secao.api.dto.request;

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
