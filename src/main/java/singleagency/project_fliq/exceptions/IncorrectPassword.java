package singleagency.project_fliq.exceptions;

public class IncorrectPassword extends FliqException {
    public IncorrectPassword() {
        super("Senha incorreta.");
    }
}
