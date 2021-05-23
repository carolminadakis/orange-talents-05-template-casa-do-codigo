package br.com.zupacademy.carolminadakis.casadocodigo.livro.repository;

import br.com.zupacademy.carolminadakis.casadocodigo.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
