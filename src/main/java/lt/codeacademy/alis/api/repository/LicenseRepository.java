package lt.codeacademy.alis.api.repository;

import lt.codeacademy.alis.api.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
public interface LicenseRepository extends JpaRepository<License, UUID> {

    List<License> findByName(String name);

    List<License> findByNameLikeOrDescriptionLike(String name, String description);

    License findByNr(Integer nr);
}
