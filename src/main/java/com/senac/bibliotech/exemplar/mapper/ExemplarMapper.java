package com.senac.bibliotech.exemplar.mapper;


import com.senac.bibliotech.exemplar.api.request.ExemplarRequest;
import com.senac.bibliotech.exemplar.api.response.ExemplarResponse;
import com.senac.bibliotech.exemplar.model.Exemplar;
import com.senac.bibliotech.livro.mapper.LivroMapper;
import com.senac.bibliotech.secao.mapper.SecaoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",
uses = {
        LivroMapper.class,
        SecaoMapper.class
})
public interface ExemplarMapper {

    ExemplarResponse toResponse(Exemplar exemplar);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "livro", ignore = true)
    @Mapping(target = "secao", ignore = true)
    Exemplar createExemplar(ExemplarRequest exemplarRequest);

}
