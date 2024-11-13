package singleagency.project_fliq.exceptions;

public class UserAlreadyExistsException extends FliqException {

    public UserAlreadyExistsException() {
        super("Email já cadastrado.");
    }
}
