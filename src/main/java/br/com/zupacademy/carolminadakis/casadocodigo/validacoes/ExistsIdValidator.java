package br.com.zupacademy.carolminadakis.casadocodigo.validacoes;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {


    private String domainAttribute;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(ExistsId parametros) {
        domainAttribute = parametros.fieldName();
        aClass = parametros.domainClass();
    }

    @Override
    public boolean isValid(Object valor, ConstraintValidatorContext contexto) {
        Query q = em.createQuery("SELECT 1 FROM "+aClass.getName()+" WHERE "+domainAttribute+"=:value");
        System.out.println("QUERY:"+ q);
        q.setParameter("value", valor);

        List<?> list = q.getResultList();
        Assert.isTrue(list.size() <=1, "você tem mais de um "+aClass+" com o atributo "+domainAttribute+" com o valor = "+valor);

        return !list.isEmpty();
    }
}
