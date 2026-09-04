package com.senac.bibliotech.categoria.mapper;


import com.senac.bibliotech.categoria.api.request.CategoriaRequest;
import com.senac.bibliotech.categoria.model.Categoria;
import com.senac.bibliotech.categoria.repository.CategoriaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {


    Categoria toCategoria(CategoriaRequest categoriaRequest);

    void updateCategoria(CategoriaRequest categoriaRequest, @MappingTarget Categoria categoria);
}
