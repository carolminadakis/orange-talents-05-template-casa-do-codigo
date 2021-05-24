package br.com.zupacademy.carolminadakis.casadocodigo.pais.controller.request;

import br.com.zupacademy.carolminadakis.casadocodigo.pais.model.Pais;
import br.com.zupacademy.carolminadakis.casadocodigo.validacoes.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "O país informado já existe")
    private String nome;

    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public PaisRequest() {
    }

    public String getNome() { return nome; }

    public Pais converter() {
        return new Pais(this.nome);
    }
}



