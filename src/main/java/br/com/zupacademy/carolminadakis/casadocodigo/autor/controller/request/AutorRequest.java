package br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.request;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;
    @Email  @NotBlank
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }


    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }



}
