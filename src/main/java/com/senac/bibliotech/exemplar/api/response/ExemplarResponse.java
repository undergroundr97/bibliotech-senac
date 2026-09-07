package com.senac.bibliotech.exemplar.api.response;

import com.senac.bibliotech.exemplar.model.Disponibilidade;
import com.senac.bibliotech.livro.domain.Livro;
import com.senac.bibliotech.secao.domain.Secao;

import java.time.LocalDateTime;

public record ExemplarResponse(
        Long id,
        String codigoPatrimonio,
        Disponibilidade disponibilidade,
        LocalDateTime dataAquisicao,
        Livro livro,
        Secao secao
) {
}
