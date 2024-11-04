package singleagency.project_fliq.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserNotFoundException extends FliqException {

    private final String detail;

    public UserNotFoundException(String detail) {
        this.detail = detail;
    }
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("User not found");
        problemDetail.setDetail(detail);

        return problemDetail;
    }
}
