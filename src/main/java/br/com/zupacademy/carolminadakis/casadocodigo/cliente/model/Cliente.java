package br.com.zupacademy.carolminadakis.casadocodigo.cliente.model;

import br.com.zupacademy.carolminadakis.casadocodigo.estado.model.Estado;
import br.com.zupacademy.carolminadakis.casadocodigo.pais.model.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "cliente")
    @NotBlank
    private String email;

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;
    @NotBlank
    private String telefone;

    @ManyToOne
    private Estado estado;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Cliente(String email, String nome,
                   String sobrenome, String documento,
                   String endereco, String complemento,
                   String cidade, String cep,
                   String telefone, Pais pais) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.pais = pais;
    }

    public Cliente() {
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id + "}";
    }
}
