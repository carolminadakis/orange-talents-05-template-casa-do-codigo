package br.com.zupacademy.carolminadakis.casadocodigo.autor.validacaoEmail;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.request.AutorRequest;

import br.com.zupacademy.carolminadakis.casadocodigo.autor.model.Autor;
import br.com.zupacademy.carolminadakis.casadocodigo.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ImpedeEmailDuplicado implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {

        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        AutorRequest request = (AutorRequest) target;
       Optional<Autor> autorExistente = autorRepository.findByEmail(request.getEmail());

       if(autorExistente.isPresent()) {
           errors.rejectValue("email", null, "Email já cadastrado " + request.getEmail());
       }
    }
}
