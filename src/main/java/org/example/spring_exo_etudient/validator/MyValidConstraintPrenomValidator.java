package org.example.spring_exo_etudient.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyValidConstraintPrenomValidator implements ConstraintValidator<MyValidPrenom,  String > {
    private String charContain;

    @Override
    public void initialize(MyValidPrenom constraintAnnotation) {
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
