package lt.codeacademy.alis.api.controller;

import io.swagger.annotations.Api;
import lt.codeacademy.alis.api.Endpoint;
import lt.codeacademy.alis.api.entity.Area;
import lt.codeacademy.alis.api.entity.License;
import lt.codeacademy.alis.api.service.AreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
@RestController
@RequestMapping(Endpoint.AREAS)
@Api(tags = "AREA CONTROLLER")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Area> getAreas(){
        return areaService.getAreas();
    }

    @GetMapping(value = Endpoint.AREA, produces = MediaType.APPLICATION_JSON_VALUE)
    public Area getArea(@PathVariable UUID uuid){
        return areaService.getArea(uuid);
    }

    @GetMapping(value = "/{query}/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Area> findAreasByQuery(@PathVariable String query){
        return areaService.findAreasByQuery(query);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createArea(@Valid @RequestBody Area area){
        areaService.addArea(area);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = Endpoint.AREA)
    public void deleteArea(@PathVariable UUID uuid){
        areaService.delete(uuid);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping
    public Area updateArea(@Valid @RequestBody Area area){
        return areaService.update(area);
    }
}
