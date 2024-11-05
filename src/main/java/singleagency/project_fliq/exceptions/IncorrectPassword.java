package singleagency.project_fliq.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class IncorrectPassword extends FliqException {
    private final String detail;

    public IncorrectPassword(String detail) {
        this.detail = detail;
    }
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Credenciais inválidas");
        problemDetail.setDetail(detail);

        return problemDetail;
    }
}
