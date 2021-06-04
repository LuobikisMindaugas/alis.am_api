package lt.codeacademy.alis.api.controller;

import lt.codeacademy.alis.api.Endpoint;
import lt.codeacademy.alis.api.entity.Area;
import lt.codeacademy.alis.api.entity.License;
import lt.codeacademy.alis.api.service.AreaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
@RestController
@RequestMapping(Endpoint.API_ROOT + Endpoint.AREAS)
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

}
