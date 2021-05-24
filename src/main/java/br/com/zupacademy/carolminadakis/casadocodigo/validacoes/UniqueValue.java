package br.com.zupacademy.carolminadakis.casadocodigo.validacoes;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Constraint(validatedBy = {UniqueValueValidador.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {

    String message() default "{br.com.zupacademy.beanvalidation.uniquevalue}";

    Class<?>[] groups() default { };

    Class<? extends Payload> [] payload() default { };

    String fieldName();

    Class<?> domainClass();
}
