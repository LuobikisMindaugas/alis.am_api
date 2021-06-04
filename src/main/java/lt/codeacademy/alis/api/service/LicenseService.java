package lt.codeacademy.alis.api.service;

import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.alis.api.entity.License;
import lt.codeacademy.alis.api.exception.LicenseNotFoundException;
import lt.codeacademy.alis.api.repository.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @Author Mindaugas Luobikis
 */
@Service
@Slf4j
public class LicenseService {

    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public License getLicense(UUID id) {
        return licenseRepository.findById(id)
                .orElseThrow(() -> new LicenseNotFoundException(id.toString()));
    }

    public List<License> getLicenses() {
        return licenseRepository.findAll();
    }

    public void update(License license) {
        licenseRepository.save(license);
    }

    public void delete(UUID id) {
        licenseRepository.deleteById(id);
    }

    public License getByName(String name) {
        return licenseRepository.findByName(name).get(0);
    }

    public License getByNr(Integer nr){
        return licenseRepository.findByNr(nr);
    }

    public List<License> findLicensesByQuery(String query) {

        if (query == null || query.length() == 0) {
            return Collections.emptyList();
        }

        return licenseRepository.findByNameLikeOrDescriptionLike("%"+query+"%", "%"+query+"%");
    }
}
