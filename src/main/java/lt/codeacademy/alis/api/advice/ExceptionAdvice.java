package lt.codeacademy.alis.api.advice;

import lt.codeacademy.alis.api.exception.AreaNotFoundException;
import lt.codeacademy.alis.api.exception.ExceptionResponse;
import lt.codeacademy.alis.api.exception.LicenseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Mindaugas Luobikis
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(LicenseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingLicenseNotFoundException(LicenseNotFoundException exception){
        return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AreaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlingAreaNotFoundException(AreaNotFoundException exception){
        return new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
