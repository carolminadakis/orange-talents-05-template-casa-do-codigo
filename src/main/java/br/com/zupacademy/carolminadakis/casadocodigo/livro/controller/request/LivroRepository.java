package br.com.zupacademy.carolminadakis.casadocodigo.livro.controller.request;

import br.com.zupacademy.carolminadakis.casadocodigo.livro.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
