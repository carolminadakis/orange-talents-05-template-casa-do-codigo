package br.com.zupacademy.carolminadakis.casadocodigo.livro.controller.request;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;
import br.com.zupacademy.carolminadakis.casadocodigo.autor.repository.AutorRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.categoria.modelo.Categoria;
import br.com.zupacademy.carolminadakis.casadocodigo.categoria.repository.CategoriaRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.livro.modelo.Livro;
import br.com.zupacademy.carolminadakis.casadocodigo.validarErros.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private int quantidadePaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @NotNull        //verificar
    private Long autorId;

    @NotNull
    @ManyToOne      //verificar
    private Long categoriaId;

    public LivroRequest(String titulo, String resumo, String sumario,
                        BigDecimal preco, int quantidadePaginas,
                        String isbn,
                        Long autorId, Long categoriaId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.quantidadePaginas = quantidadePaginas;
        this.isbn = isbn;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro converte(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Autor autor = autorRepository.getOne(autorId);
        Categoria categoria = categoriaRepository.getOne(categoriaId);

        return new Livro(titulo, resumo, sumario, preco, quantidadePaginas,
                isbn, dataPublicacao, autor, categoria);
    }
}
