package com.senac.bibliotech.repository;

import com.senac.bibliotech.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
