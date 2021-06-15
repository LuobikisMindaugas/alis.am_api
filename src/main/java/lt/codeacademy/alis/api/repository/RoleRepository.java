package lt.codeacademy.alis.api.repository;

import lt.codeacademy.alis.api.entity.License;
import lt.codeacademy.alis.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
public interface RoleRepository extends JpaRepository<Role, UUID> {

    Role findByName(String name);
}
