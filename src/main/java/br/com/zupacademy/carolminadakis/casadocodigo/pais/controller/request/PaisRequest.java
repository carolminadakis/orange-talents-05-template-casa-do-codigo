package br.com.zupacademy.carolminadakis.casadocodigo.pais.controller.request;

import br.com.zupacademy.carolminadakis.casadocodigo.pais.model.Pais;
import br.com.zupacademy.carolminadakis.casadocodigo.validarErros.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName =  "nome")
    private String nome;

    public String getNome() { return nome; }

    public Pais converter() {
        return new Pais(this.nome);
    }
}



