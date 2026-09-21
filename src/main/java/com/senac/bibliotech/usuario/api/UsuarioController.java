package com.senac.bibliotech.usuario.api;


import com.senac.bibliotech.usuario.api.request.UsuarioRequest;
import com.senac.bibliotech.usuario.api.response.UsuarioResponse;
import com.senac.bibliotech.usuario.domain.Usuario;
import com.senac.bibliotech.usuario.repository.UsuarioRepository;
import com.senac.bibliotech.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    public ResponseEntity<List<UsuarioResponse>> getAllUsuarios(){

        return ResponseEntity.ok(usuarioService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findUsuarioById(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> postUsuario(@RequestBody
                                                       @Valid
                                                       UsuarioRequest
                                                       usuarioRequest){

        return ResponseEntity.ok(usuarioService.save(usuarioRequest));

    }
}
