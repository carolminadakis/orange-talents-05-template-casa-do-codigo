package br.com.zupacademy.carolminadakis.casadocodigo.estado.model;

import br.com.zupacademy.carolminadakis.casadocodigo.pais.model.Pais;


import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Estado() {
    }
}
