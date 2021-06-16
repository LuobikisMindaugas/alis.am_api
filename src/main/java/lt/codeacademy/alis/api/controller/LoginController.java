package lt.codeacademy.alis.api.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.alis.api.dto.LoggedInUserDto;
import lt.codeacademy.alis.api.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Mindaugas Luobikis
 */
@RestController
@RequestMapping("/login")
@Api(tags = "LOGIN CONTROLLER")
public class LoginController {

    @PostMapping
    public LoggedInUserDto login(@AuthenticationPrincipal User user) {

        return new LoggedInUserDto(user);
    }
}
