package lt.codeacademy.alis.api.exception;

import lombok.Getter;

/**
 * @Author Mindaugas Luobikis
 */
@Getter
public class RoleNotFoundException extends RuntimeException{

    private final String roleId;
    private final String message;

    public RoleNotFoundException(String roleId){
        this.roleId = roleId;
        message = String.format("Role %s does not exist", roleId);
    }
}
