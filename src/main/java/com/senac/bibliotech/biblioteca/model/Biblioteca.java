package com.senac.bibliotech.biblioteca.model;


import com.senac.bibliotech.secao.domain.Secao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "biblioteca")
@Data
@NoArgsConstructor
public class Biblioteca {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;


    @OneToMany(mappedBy = "biblioteca")
    private List<Secao> secaoList;


}
