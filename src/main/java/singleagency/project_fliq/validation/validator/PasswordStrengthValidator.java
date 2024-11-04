package singleagency.project_fliq.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import singleagency.project_fliq.validation.annotation.PasswordStrenght;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordStrenght, String> {
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?=.{8,}).*$";

    @Override
    public void initialize(PasswordStrenght constraintAnnotation) {}

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password != null && password.matches(PASSWORD_PATTERN);
    }
}
