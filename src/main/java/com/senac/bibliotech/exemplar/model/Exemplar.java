package com.senac.bibliotech.exemplar.model;


import com.senac.bibliotech.livro.domain.Livro;
import com.senac.bibliotech.secao.domain.Secao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "exemplar")
@Data
@NoArgsConstructor
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "codigo_patrimonio")
    private String codigoPatrimonio;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Disponibilidade status;

    @Column(name = "data_aquisicao")
    private LocalDateTime dataAquisicao;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "secao_id")
    private Secao secao;


}
