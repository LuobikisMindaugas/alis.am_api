package lt.codeacademy.alis.api.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.alis.api.entity.User;
import lt.codeacademy.alis.api.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;


    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public void addUser(User user) {
        try {
            if (user == null) {
                return;
            }
            user.setRoles(roleService.getDefaultRoleSet());
            //user.setPassword(encoder.encoder(user.getPassword()));
            userRepository.save(user);
        } catch (IllegalArgumentException e) {
            log.error("Cannot create user {}", user);
        }
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findWithRolesByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }


}
