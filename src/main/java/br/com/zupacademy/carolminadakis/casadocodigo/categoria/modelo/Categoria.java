package br.com.zupacademy.carolminadakis.casadocodigo.categoria.modelo;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Categoria() {

    }
=======
public class Categoria {
>>>>>>> f9bee3a98bd4d72e11b41d87ac049132d00e5acb
}
