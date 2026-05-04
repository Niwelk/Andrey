package monolit.book_assistant.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice(basePackages = "monolit.book_assistant.controller")
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException (NoSuchElementException ex) {
        log.error("NoSuchElementException caught: ", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("IllegalArgumentException caught: ", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect book entry ");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException caught: ", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect argument"); //что вставить в body? так оставить?
    }
}
