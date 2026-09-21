package com.senac.bibliotech.usuario.repository;

import com.senac.bibliotech.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}