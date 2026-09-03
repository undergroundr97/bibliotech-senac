package com.senac.bibliotech.repository;

import com.senac.bibliotech.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
