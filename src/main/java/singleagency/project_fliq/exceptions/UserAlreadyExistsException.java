package singleagency.project_fliq.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserAlreadyExistsException extends FliqException {

    private final String detail;

    public UserAlreadyExistsException(String detail) {
        this.detail = detail;
    }

    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("Usuário já existe!");
        problemDetail.setDetail(detail);

        return problemDetail;
    }
}
