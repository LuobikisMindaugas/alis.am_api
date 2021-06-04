package lt.codeacademy.alis.api.repository;

import lt.codeacademy.alis.api.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
public interface AreaRepository extends JpaRepository<Area, UUID> {
    List<Area> findByNameLike(String query);
}
