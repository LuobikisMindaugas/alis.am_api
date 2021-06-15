package lt.codeacademy.alis.api.dto;

import lombok.Data;
import lt.codeacademy.alis.api.entity.Role;
import lt.codeacademy.alis.api.entity.User;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Data
public class LoggedInUserDto {
    private String username;
    private Set<String> roles;
    private String name;

    public LoggedInUserDto(User user) {
        this.username = user.getUsername();
        this.roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(toSet());
        this.name = user.getName();
    }
}
