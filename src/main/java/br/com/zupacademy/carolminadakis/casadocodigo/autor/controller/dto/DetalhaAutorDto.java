package br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.dto;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;

public class DetalhaAutorDto {

    private String nome;
    private String descricao;

    public DetalhaAutorDto(Autor autor) {   //busca as informações no banco de dados
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }
}
