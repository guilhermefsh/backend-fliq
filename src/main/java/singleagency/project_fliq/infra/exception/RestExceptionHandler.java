package singleagency.project_fliq.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import singleagency.project_fliq.exceptions.FliqException;
import singleagency.project_fliq.exceptions.MaxRestaurantsForPlan;
import singleagency.project_fliq.exceptions.UserAlreadyExistsException;
import singleagency.project_fliq.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFound(FliqException exception){
        return ResponseEntity.badRequest()
                .body(Map.of("ErrorDetail", exception.getErrorDetail()));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExists(FliqException exception){
        return ResponseEntity.unprocessableEntity()
                .body(Map.of("ErrorDetail", exception.getErrorDetail()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<InvalidParam>>> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {

        List<InvalidParam> fieldErrors = exception.getFieldErrors()
                .stream()
                .map(fieldError -> new InvalidParam(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        return ResponseEntity.badRequest()
                .body(Map.of("Invalid-params", fieldErrors));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        return ResponseEntity.badRequest()
                .body(Map.of("ErrorDetail", "O corpo da requisição não é válido"));
    }

    @ExceptionHandler(MaxRestaurantsForPlan.class)
    public ResponseEntity<Map<String, String>> handleMaxRestaurantsForPlan(FliqException exception) {
        return ResponseEntity.badRequest()
                .body(Map.of("ErrorDetail", exception.getMessage()));
    }
}

