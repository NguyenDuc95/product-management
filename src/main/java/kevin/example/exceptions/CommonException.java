package kevin.example.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class CommonException extends RuntimeException {
    private String errorCode;
    private Integer status;

    public CommonException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.setErrorCode(code);
        this.setStatus(httpStatus.value());
    }

    public CommonException(String message) {
        super(message);
    }

}
