package br.com.zupacademy.carolminadakis.casadocodigo.livro.modelo;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;
import br.com.zupacademy.carolminadakis.casadocodigo.categoria.modelo.Categoria;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotNull @Min(20)
    private BigDecimal preco;
    @Min(100)
    private int quantidadePaginas;
    @NotBlank
    private String isbn;
    @Future
    private LocalDate dataPublicacao;
    @NotNull
    @ManyToOne
    @Valid
    private Autor autor;
    @NotNull
    @ManyToOne
    @Valid
    private Categoria categoria;

    @Deprecated
    public Livro() {

    }

    public Livro(String titulo, String resumo, String sumario,
                 BigDecimal preco, int quantidadePaginas,
                 String isbn, LocalDate dataPublicacao,
                 Autor autor, Categoria categoria) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.quantidadePaginas = quantidadePaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Long getId() { return id; }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
