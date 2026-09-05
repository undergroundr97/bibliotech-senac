package com.senac.bibliotech.secao.mapper;


import com.senac.bibliotech.secao.api.dto.response.SecaoResponse;
import com.senac.bibliotech.secao.domain.Secao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SecaoMapper {

    SecaoResponse toResponse(Secao secao);
}
