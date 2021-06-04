package lt.codeacademy.alis.api.exception;

import lombok.Getter;

/**
 * @Author Mindaugas Luobikis
 */

@Getter
public class AreaNotFoundException extends RuntimeException {

    private final String licenseId;

    public AreaNotFoundException(String licenseId){
        this.licenseId = licenseId;
    }
}
