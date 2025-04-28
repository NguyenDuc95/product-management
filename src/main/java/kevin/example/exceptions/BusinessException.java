package kevin.example.exceptions;

import kevin.example.common.ApplicationCode;
import org.springframework.http.HttpStatus;

public class BusinessException extends CommonException {

    public BusinessException(String message) {
        super(ApplicationCode.BUSINESS_ERROR, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public BusinessException(String code, String message) {
        super(code, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
