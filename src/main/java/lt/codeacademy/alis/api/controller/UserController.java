package lt.codeacademy.alis.api.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.alis.api.entity.License;
import lt.codeacademy.alis.api.entity.User;
import lt.codeacademy.alis.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author Mindaugas Luobikis
 */
@RestController
@RequestMapping("/users")
@Api(tags = "USER CONTROLLER")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        return userService.getUsers();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createLicense(@Valid @RequestBody User user){
        userService.addUser(user);
    }
}
