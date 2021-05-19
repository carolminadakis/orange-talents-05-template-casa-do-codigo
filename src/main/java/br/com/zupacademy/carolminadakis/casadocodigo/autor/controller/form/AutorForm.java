package br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.form;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorForm {

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


    public Autor converter(AutorForm autorForm) {
        return new Autor(nome, email, descricao);
    }



}
