package com.senac.bibliotech.usuario.domain;

import com.senac.bibliotech.emprestimo.domain.Emprestimo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;


    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimoList;


}
