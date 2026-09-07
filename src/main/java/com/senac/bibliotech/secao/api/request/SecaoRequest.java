package com.senac.bibliotech.secao.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SecaoRequest(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotBlank
        String localizacao,
        @Positive
        @NotNull
        Long bibliotecaId
) {
}
