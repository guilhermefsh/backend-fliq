package singleagency.project_fliq.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class FliqException extends RuntimeException {

    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        problemDetail.setTitle("Fliq internal server error");

        return problemDetail;
    }
}
