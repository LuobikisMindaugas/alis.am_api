package lt.codeacademy.alis.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @Author Mindaugas Luobikis
 */

@Getter
public class ExceptionResponse {

    private final String message;
    private final Long timeStamp;
    private final int status;

    public ExceptionResponse(String message, HttpStatus status){
        this.message = message;
        this.status = status.value();
        timeStamp = LocalDateTime.now().atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli();
    }
}
