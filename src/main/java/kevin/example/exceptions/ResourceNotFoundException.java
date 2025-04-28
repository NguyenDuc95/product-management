package kevin.example.exceptions;

import kevin.example.common.ApplicationCode;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends CommonException {

    public ResourceNotFoundException(String message) {
        super(ApplicationCode.RESOURCE_NOT_FOUND, message, HttpStatus.NOT_FOUND);
    }

    public ResourceNotFoundException(String code, String message) {
        super(code, message, HttpStatus.NOT_FOUND);
    }
}
