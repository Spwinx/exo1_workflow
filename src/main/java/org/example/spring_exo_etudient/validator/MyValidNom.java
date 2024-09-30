package org.example.spring_exo_etudient.validator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MyValidConstraintNomValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyValidNom {
    public String value() default "t";
    public String message() default "Le Nom doit avoir la lettre t!";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
