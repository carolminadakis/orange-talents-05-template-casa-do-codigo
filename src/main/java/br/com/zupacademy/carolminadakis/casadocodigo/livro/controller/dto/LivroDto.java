package br.com.zupacademy.carolminadakis.casadocodigo.livro.controller.dto;

import br.com.zupacademy.carolminadakis.casadocodigo.livro.model.Livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {

    private Long id;
    private String titulo;

    public LivroDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() { return id; }

    public String getTitulo() { return titulo; }


    public static List<LivroDto> converter(List<Livro> lista) {
        List<LivroDto>  livrosDto = lista.stream()
                                        .map((livro) -> new LivroDto(livro.getId(), livro.getTitulo()))
                                        .collect(Collectors.toList());
       return livrosDto;
    }
}
