package br.com.zupacademy.carolminadakis.casadocodigo.autor.validacao;


<<<<<<< HEAD
import br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.request.AutorRequest;
=======
import br.com.zupacademy.carolminadakis.casadocodigo.autor.controller.form.AutorForm;
>>>>>>> f9bee3a98bd4d72e11b41d87ac049132d00e5acb
import br.com.zupacademy.carolminadakis.casadocodigo.autor.modelo.Autor;
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
<<<<<<< HEAD
        return AutorRequest.class.isAssignableFrom(aClass);
=======
        return AutorForm.class.isAssignableFrom(aClass);
>>>>>>> f9bee3a98bd4d72e11b41d87ac049132d00e5acb
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
<<<<<<< HEAD
        AutorRequest request = (AutorRequest) target;
=======
        AutorForm request = (AutorForm) target;
>>>>>>> f9bee3a98bd4d72e11b41d87ac049132d00e5acb
       Optional<Autor> autorExistente = autorRepository.findByEmail(request.getEmail());

       if(autorExistente.isPresent()) {
           errors.rejectValue("email", null, "Email já cadastrado " + request.getEmail());
       }
    }
}
