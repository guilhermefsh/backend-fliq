package singleagency.project_fliq.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import singleagency.project_fliq.exceptions.FliqException;
import singleagency.project_fliq.exceptions.UserAlreadyExistsException;
import singleagency.project_fliq.exceptions.UserNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFound(FliqException exception){
        return exception.toProblemDetail();
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ProblemDetail handleUserAlreadyExists(FliqException exception){
        return exception.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValid(MethodArgumentNotValidException exception){

        var filedErrors = exception.getFieldErrors()
                .stream()
                .map(fieldError -> new InvalidParam(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();


        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Erro de validação");
        problemDetail.setProperty("Invalid-params", filedErrors);

        return problemDetail;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ProblemDetail handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("O corpo da requisição não é válido");

        return problemDetail;
    }

}
