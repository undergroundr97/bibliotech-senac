package com.senac.bibliotech.categoria.repository;

import com.senac.bibliotech.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
