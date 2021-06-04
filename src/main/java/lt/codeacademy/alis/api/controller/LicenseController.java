package lt.codeacademy.alis.api.controller;

import lt.codeacademy.alis.api.Endpoint;
import lt.codeacademy.alis.api.entity.License;
import lt.codeacademy.alis.api.service.LicenseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */

@RestController
@RequestMapping(Endpoint.API_ROOT + Endpoint.LICENSES)
public class LicenseController {

    private final LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<License> getLicenses(){
        return licenseService.getLicenses();
    }

    @GetMapping(value = Endpoint.LICENSE, produces = MediaType.APPLICATION_JSON_VALUE)
    public License getLicense(@PathVariable UUID uuid){
        return licenseService.getLicense(uuid);
    }

    @GetMapping(value = "/{nr}/nr", produces = MediaType.APPLICATION_JSON_VALUE)
    public License getLicenseByNr(@PathVariable Integer nr){
        return licenseService.getByNr(nr);
    }

    @GetMapping(value = "/{query}/find", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<License> findLicensesByQuery(@PathVariable String query){
        return licenseService.findLicensesByQuery(query);
    }
}
