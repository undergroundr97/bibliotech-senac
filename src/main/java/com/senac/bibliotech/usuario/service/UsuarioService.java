package com.senac.bibliotech.usuario.service;


import com.senac.bibliotech.exceptions.customexceptions.ResourceNotFound;
import com.senac.bibliotech.usuario.api.request.UsuarioRequest;
import com.senac.bibliotech.usuario.api.response.UsuarioResponse;
import com.senac.bibliotech.usuario.domain.Usuario;
//import com.senac.bibliotech.usuario.respotiroy.UsuarioRepository;
import com.senac.bibliotech.usuario.mapper.UsuarioMapper;
import com.senac.bibliotech.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

   private final UsuarioRepository usuarioRepository;
   private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List<UsuarioResponse> findAll(){
        List<UsuarioResponse> listUsuariosResponse =
                usuarioRepository.findAll()
                        .stream()
                        .map(usuarioMapper::toResponse)
                        .toList();

        return listUsuariosResponse;
    }

    public UsuarioResponse findUsuarioById(Long id){
        Usuario usuario = findUsuarioEntityById(id);

        return usuarioMapper.toResponse(usuario);
    }

    public Usuario findUsuarioEntityById(Long id){
        return usuarioRepository.findById(id).orElseThrow( () ->
            new ResourceNotFound("Usuario com id:" +id +" was not found"));
    }


    public UsuarioResponse save(UsuarioRequest usuarioRequest){

        Usuario usuario = usuarioMapper.toEntity(usuarioRequest);

        Usuario savedUsuario = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(savedUsuario);

    }
}
