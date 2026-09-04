package com.senac.bibliotech.autor.domain;


import com.senac.bibliotech.livro.domain.Livro;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "autor")

    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Autor(Long id, String nome, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(nome, autor.nome) && Objects.equals(livros, autor.livros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, livros);
    }
}

