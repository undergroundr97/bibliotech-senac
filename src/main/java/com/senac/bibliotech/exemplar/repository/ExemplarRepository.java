package com.senac.bibliotech.exemplar.repository;

import com.senac.bibliotech.exemplar.model.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplarRepository extends JpaRepository<Exemplar,Long> {
}
