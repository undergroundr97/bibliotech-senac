package com.senac.bibliotech.categoria.model;


import com.senac.bibliotech.livro.domain.Livro;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "categoria")
@Data
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

    public Categoria(){
    }

    public Categoria(Long id, String nome, String descricao, List<Livro> livrosComCategoria) {
        Id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.livrosComCategoria = livrosComCategoria;
    }


}
