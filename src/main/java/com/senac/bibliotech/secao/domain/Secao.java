package com.senac.bibliotech.secao.domain;


import com.senac.bibliotech.exemplar.model.Exemplar;
import com.senac.bibliotech.livro.domain.Livro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "secao")
@Data
@NoArgsConstructor
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


    @OneToMany(mappedBy = "secao")
    private List<Exemplar> exemplarList;



}
