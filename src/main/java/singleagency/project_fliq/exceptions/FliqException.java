package singleagency.project_fliq.exceptions;

import lombok.Getter;

@Getter
public class FliqException extends RuntimeException {

    private final String errorDetail;

    public FliqException(String errorDetail) {
        super(errorDetail);
        this.errorDetail = errorDetail;
    }

}
