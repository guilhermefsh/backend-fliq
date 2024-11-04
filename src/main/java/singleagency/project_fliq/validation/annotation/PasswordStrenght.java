package singleagency.project_fliq.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import singleagency.project_fliq.validation.validator.PasswordStrengthValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordStrenght {
    String message() default "A senha deve ter no mínimo 8 caracteres, contendo pelo menos 1 letra maiúscula e um caractere especial";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
