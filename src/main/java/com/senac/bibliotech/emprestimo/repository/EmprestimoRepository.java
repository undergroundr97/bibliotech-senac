package com.senac.bibliotech.emprestimo.repository;


import com.senac.bibliotech.emprestimo.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
