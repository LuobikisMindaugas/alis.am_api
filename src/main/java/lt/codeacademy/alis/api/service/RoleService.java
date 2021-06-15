package lt.codeacademy.alis.api.service;

import lt.codeacademy.alis.api.entity.Area;
import lt.codeacademy.alis.api.entity.Role;
import lt.codeacademy.alis.api.entity.User;
import lt.codeacademy.alis.api.exception.AreaNotFoundException;
import lt.codeacademy.alis.api.exception.RoleNotFoundException;
import lt.codeacademy.alis.api.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author Mindaugas Luobikis
 */
@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleByName(String name){
        return roleRepository.findByName(name);
    }

    public Set<Role> getDefaultRoleSet() {
        return new HashSet<>(){{
            add(getRoleByName("USER"));
        }};
    }


}
