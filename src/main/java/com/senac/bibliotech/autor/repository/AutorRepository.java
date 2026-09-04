package com.senac.bibliotech.autor.repository;

import com.senac.bibliotech.autor.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
