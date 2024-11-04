package singleagency.project_fliq.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import singleagency.project_fliq.validation.annotation.PasswordStrenght;

public record CreateUserDto(
        @NotBlank(message = "O campo email não deve estar vazio!") @Email(message = "Email inválido") String email,
        @PasswordStrenght String password,
        @NotBlank(message = "O campo nome não deve estar vazio!") String name) {
}
