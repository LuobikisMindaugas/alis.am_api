package lt.codeacademy.alis.api.exception;

import lombok.Getter;

/**
 * @Author Mindaugas Luobikis
 */

@Getter
public class LicenseNotFoundException extends RuntimeException {

    private final String licenseId;

    public LicenseNotFoundException(String licenseId){
        this.licenseId = licenseId;
    }
}
