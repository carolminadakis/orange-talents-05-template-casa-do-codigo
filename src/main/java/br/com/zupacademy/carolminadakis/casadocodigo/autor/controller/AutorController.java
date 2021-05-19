package br.com.zupacademy.carolminadakis.casadocodigo.autor.controller;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.form.AutorForm;
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
    public ResponseEntity<AutorForm> cadastro(@RequestBody @Valid AutorForm autorForm) {
        Autor autor = autorForm.converter(autorForm);
        autorRepository.save(autor);

        return ResponseEntity.ok().build();

    }
}

