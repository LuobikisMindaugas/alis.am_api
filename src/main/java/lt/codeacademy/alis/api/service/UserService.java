package lt.codeacademy.alis.api.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.alis.api.entity.User;
import lt.codeacademy.alis.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Mindaugas Luobikis
 */
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        try {
            if (user == null) {
                return;
            }
            userRepository.save(user);
        } catch (IllegalArgumentException e) {
            log.error("Cannot create area {}", user);
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
