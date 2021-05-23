package br.com.zupacademy.carolminadakis.casadocodigo.livro.controller;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.repository.AutorRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.categoria.repository.CategoriaRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.livro.controller.dto.DetalhaLivroDto;
import br.com.zupacademy.carolminadakis.casadocodigo.livro.controller.dto.LivroDto;
import br.com.zupacademy.carolminadakis.casadocodigo.livro.repository.LivroRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.livro.model.Livro;
import br.com.zupacademy.carolminadakis.casadocodigo.livro.controller.request.LivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;


    @PostMapping
    @Transactional
    public ResponseEntity cria(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.converte(autorRepository, categoriaRepository);
        livroRepository.save(livro);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<LivroDto> lista() {
        List<Livro> listaLivro = livroRepository.findAll();
        return LivroDto.converter(listaLivro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhaLivroDto> detalha(@PathVariable Long id) {
      Optional<Livro> livro = livroRepository.findById(id);

      if (livro.isPresent()) {
          DetalhaLivroDto detalhaLivroDto = new DetalhaLivroDto(livro.get());
          return ResponseEntity.ok(detalhaLivroDto);
      }
      return ResponseEntity.notFound().build();
    }
}
