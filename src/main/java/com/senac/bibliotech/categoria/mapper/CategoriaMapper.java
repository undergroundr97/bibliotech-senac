package com.senac.bibliotech.categoria.mapper;


import com.senac.bibliotech.categoria.api.request.CategoriaPatchRequest;
import com.senac.bibliotech.categoria.api.request.CategoriaRequest;
import com.senac.bibliotech.categoria.api.response.CategoriaResponse;
import com.senac.bibliotech.categoria.model.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {


    Categoria toCategoria(CategoriaRequest categoriaRequest);
    CategoriaResponse toResponse(Categoria categoria);


    void putCategoria(CategoriaRequest categoriaRequest, @MappingTarget Categoria categoria);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchCategoria(CategoriaPatchRequest categoriaPatchRequest, @MappingTarget Categoria categoria);

}
