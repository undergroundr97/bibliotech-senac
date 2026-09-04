package com.senac.bibliotech.livro.repository;

import com.senac.bibliotech.livro.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
