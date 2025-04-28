package kevin.example.exceptions;

import kevin.example.common.ApplicationCode;
import org.springframework.http.HttpStatus;

public class BadRequestException extends CommonException {

    public BadRequestException(String message) {
        super(ApplicationCode.BAD_REQUEST, message, HttpStatus.BAD_REQUEST);
    }

    public BadRequestException(String code, String message) {
        super(code, message, HttpStatus.BAD_REQUEST);
    }
}
