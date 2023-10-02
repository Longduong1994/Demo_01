package demo_01.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {
    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<String> categoryFail(ClassCastException classCastException) {
        return new ResponseEntity<>(classCastException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
