package com.senac.bibliotech.biblioteca.repository;

import com.senac.bibliotech.biblioteca.model.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
