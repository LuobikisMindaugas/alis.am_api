package lt.codeacademy.alis.api.exception;

import lombok.Getter;

/**
 * @Author Mindaugas Luobikis
 */

@Getter
public class AreaNotFoundException extends RuntimeException {

    private final String areaId;
    private final String message;

    public AreaNotFoundException(String areaId){
        this.areaId = areaId;
        message = String.format("Area %s not found", areaId);
    }
}
