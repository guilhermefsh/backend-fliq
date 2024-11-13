package singleagency.project_fliq.exceptions;

public class UserNotFoundException extends FliqException {

    public UserNotFoundException() {
        super("Usuário não encontrado.");
    }
}
