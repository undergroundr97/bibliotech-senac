package com.senac.bibliotech.categoria.model;


import com.senac.bibliotech.livro.domain.Livro;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livrosComCategoria;

}
