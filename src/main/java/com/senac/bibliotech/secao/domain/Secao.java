package com.senac.bibliotech.secao.domain;


import com.senac.bibliotech.livro.domain.Livro;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "secao")
public class Secao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name =  "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name =  "localizacao")
    private String localizacao;


    @OneToMany
    private List<Livro> livrosSecao;


}
