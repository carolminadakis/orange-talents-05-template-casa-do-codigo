package br.com.zupacademy.carolminadakis.casadocodigo.categoria.controller.request;

import br.com.zupacademy.carolminadakis.casadocodigo.categoria.modelo.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
