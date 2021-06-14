package lt.codeacademy.alis.api.security;

import lombok.Data;


/**
 * @Author Mindaugas Luobikis
 */
@Data
public class LoginDto {
    private String username;
    private String password;
}
