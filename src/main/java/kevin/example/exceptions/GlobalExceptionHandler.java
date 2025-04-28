package kevin.example.exceptions;

import kevin.example.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(CommonException ex){
        return ResponseEntity.status(ex.getStatus()).body(new ErrorResponse(ex.getErrorCode(), ex.getMessage()));
    }
}
