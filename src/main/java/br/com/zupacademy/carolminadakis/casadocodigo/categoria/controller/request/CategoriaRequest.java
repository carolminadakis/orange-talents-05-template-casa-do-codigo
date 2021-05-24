package br.com.zupacademy.carolminadakis.casadocodigo.categoria.controller.request;

import br.com.zupacademy.carolminadakis.casadocodigo.categoria.model.Categoria;
import br.com.zupacademy.carolminadakis.casadocodigo.validacoes.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
