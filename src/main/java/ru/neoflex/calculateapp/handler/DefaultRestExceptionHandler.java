package ru.neoflex.calculateapp.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.neoflex.calculateapp.exception.NoCorrectDateException;
import ru.neoflex.calculateapp.exception.NoCorrectSumException;

@RestControllerAdvice
public class DefaultRestExceptionHandler {

    @ExceptionHandler(NoCorrectDateException.class)
    public ResponseEntity<String> handleDateRangeException(NoCorrectDateException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleSumException(NoCorrectSumException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
