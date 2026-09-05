package com.senac.bibliotech.secao.mapper;


import com.senac.bibliotech.secao.api.dto.request.SecaoRequest;
import com.senac.bibliotech.secao.api.dto.response.SecaoResponse;
import com.senac.bibliotech.secao.domain.Secao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SecaoMapper {

    SecaoResponse toResponse(Secao secao);

    @Mapping(target = "id", ignore = true)
    Secao createSecao(SecaoRequest secaoRequest);

}
