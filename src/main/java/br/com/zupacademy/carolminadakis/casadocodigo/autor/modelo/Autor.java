package br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Email @NotBlank
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    @NotNull
    private LocalDateTime momentoCriacao = LocalDateTime.now();

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        Assert.hasLength(nome, "O campo nome é obrigatório!");  //joga um erro no caso de tentarem cadastrar sem preencher o nome
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
