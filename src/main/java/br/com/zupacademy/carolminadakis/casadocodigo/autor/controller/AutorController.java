package br.com.zupacademy.carolminadakis.casadocodigo.autor.controller;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.request.AutorRequest;
import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;
import br.com.zupacademy.carolminadakis.casadocodigo.autor.repository.AutorRepository;
import br.com.zupacademy.carolminadakis.casadocodigo.autor.validacao.ImpedeEmailDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    private ImpedeEmailDuplicado impedeEmailDuplicado;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(impedeEmailDuplicado);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AutorRequest> cadastro(@RequestBody @Valid AutorRequest autorRequest) {
        Autor autor = autorRequest.converter();
        autorRepository.save(autor);

        return ResponseEntity.ok().build();

    }
}

