package lt.codeacademy.alis.api.repository;

import lt.codeacademy.alis.api.entity.Area;
import lt.codeacademy.alis.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
public interface UserRepository extends JpaRepository<User, UUID> {
}
