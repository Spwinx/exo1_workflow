package org.example.spring_exo_etudient.validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MyValidConstraintPrenomValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyValidPrenom {
    public String value() default "r";
    public String message() default "Le prenom doit contenir la lettre r";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
