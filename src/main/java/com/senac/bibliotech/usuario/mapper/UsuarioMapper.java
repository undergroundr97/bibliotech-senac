package com.senac.bibliotech.usuario.mapper;


import com.senac.bibliotech.usuario.api.request.UsuarioRequest;
import com.senac.bibliotech.usuario.api.response.UsuarioResponse;
import com.senac.bibliotech.usuario.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "emprestimoList", ignore = true)
    Usuario toEntity(UsuarioRequest usuarioRequest);


    UsuarioResponse toResponse(Usuario usuario);
}
