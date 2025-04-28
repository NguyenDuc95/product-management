package kevin.example.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String errorCode;
    private String message;
    private LocalDateTime timestamp;
    public ErrorResponse(String errorCode, String message){
        this.setErrorCode(errorCode);
        this.setMessage(message);
        this.setTimestamp(LocalDateTime.now());
    }
}
