package br.com.zupacademy.carolminadakis.casadocodigo.livro.controller.dto;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.dto.DetalhaAutorDto;
import br.com.zupacademy.carolminadakis.casadocodigo.livro.model.Livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class DetalhaLivroDto {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int quantidadePaginas;
    private String isbn;
    private String dataPublicacao;
    private DetalhaAutorDto detalhaAutorDto;


    public DetalhaLivroDto(Livro livro) {   //recebe um tipo Livro como argumento para buscar no banco as informações
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.quantidadePaginas = livro.getQuantidadePaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.detalhaAutorDto = new DetalhaAutorDto(livro.getAutor());   //busca as informações no DetalhaAutor
    }
}
