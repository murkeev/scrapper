package murkeev.scrapper.exceptions.handles;

import murkeev.scrapper.exceptions.EntityNotFoundException;
import murkeev.scrapper.exceptions.ScrapException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ScrapException.class)
    public ResponseEntity<ErrorResponse> handleIncorrectLoginOrPasswordException(ScrapException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleEntityManipulationException(RuntimeException e) {
        return ResponseEntity.status(500).body(new ErrorResponse(e.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(404).body(new ErrorResponse(e.getMessage(), LocalDateTime.now()));
    }
}