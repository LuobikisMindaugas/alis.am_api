package lt.codeacademy.alis.api.exception;

import lombok.Getter;

/**
 * @Author Mindaugas Luobikis
 */

@Getter
public class LicenseNotFoundException extends RuntimeException {

    private final String licenseId;
    private final String message;

    public LicenseNotFoundException(String licenseId){
        this.licenseId = licenseId;
        message = String.format("License %s does not exist", licenseId);
    }
}
