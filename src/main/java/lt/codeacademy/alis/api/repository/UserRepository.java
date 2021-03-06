package lt.codeacademy.alis.api.repository;

import lt.codeacademy.alis.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username = :username")
    Optional<User> findWithRolesByUsername(@Param("username") String username);

}
