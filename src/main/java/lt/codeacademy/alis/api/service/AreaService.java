package lt.codeacademy.alis.api.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.alis.api.entity.Area;
import lt.codeacademy.alis.api.entity.License;
import lt.codeacademy.alis.api.exception.AreaNotFoundException;
import lt.codeacademy.alis.api.repository.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
@Service
@Slf4j
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area getArea(UUID id){
        return areaRepository.findById(id)
                .orElseThrow(() -> new AreaNotFoundException(id.toString()));
    }

    public List<Area> getAreas(){
        return areaRepository.findAll();
    }

    public List<Area> findAreasByQuery(String query) {

        if (query == null || query.length() == 0) {
            return Collections.emptyList();
        }

        return areaRepository.findByNameLike("%"+query+"%");
    }

    public Area update(Area area) {
        return areaRepository.save(area);
    }

    public void delete(UUID id) {
        areaRepository.deleteById(id);
    }

    public void addArea(Area area) {
        try {
            if (area == null) {
                return;
            }
            areaRepository.save(area);
        } catch (IllegalArgumentException e) {
            log.error("Cannot create area {}", area);
        }
    }

}
