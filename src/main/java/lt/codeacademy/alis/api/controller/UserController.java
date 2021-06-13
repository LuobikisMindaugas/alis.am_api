package lt.codeacademy.alis.api.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.alis.api.Endpoint;
import lt.codeacademy.alis.api.entity.User;
import lt.codeacademy.alis.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author Mindaugas Luobikis
 */
@RestController
@RequestMapping(Endpoint.API_ROOT + Endpoint.USERS)
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
    public void createUser(@Valid @RequestBody User user){
        userService.addUser(user);
        System.out.println(user.getName() + user.getEmail());
    }

}
