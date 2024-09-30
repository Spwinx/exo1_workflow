package org.example.spring_exo_etudient.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyValidConstraintNomValidator implements ConstraintValidator<MyValidNom,  String > {
    private String charContain;

    @Override
    public void initialize(MyValidNom constraintAnnotation) {
        charContain = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;

        if (value != null) {
            valid = value.contains(charContain);
        }
        return valid;
    }
}
