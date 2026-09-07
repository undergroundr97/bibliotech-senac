package com.senac.bibliotech.livro.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.bibliotech.autor.domain.Autor;
import com.senac.bibliotech.categoria.model.Categoria;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table( name = "livros")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    public Livro(Long id, String titulo, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public Livro() {
    }

    public Livro(Long id, String titulo, String isbn, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }


}
