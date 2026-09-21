package com.senac.bibliotech.emprestimo.domain;


import com.senac.bibliotech.usuario.domain.Usuario;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table( name = "emprestimos")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_emprestimo")
    private Instant dataEmprestimo;

    @Column(name = "data_devolucao")
    private Instant dataDevolucao;

    @Column(name = "data_prevista_devolucao")
    private Instant dataPrevistaDevolucao;

    @Column(name = "status")
    private EmprestimoStatus status;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;





}
