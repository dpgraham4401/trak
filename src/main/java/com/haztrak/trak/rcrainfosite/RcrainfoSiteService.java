package com.haztrak.trak.rcrainfosite;

import com.haztrak.trak.rcrainfosite.errors.RcrainfoSiteNotFoundException;
import com.haztrak.trak.rcrainfosite.repository.RcrainfoSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class RcrainfoSiteService {

    private final RcrainfoSiteRepository repository;

    @Autowired
    public RcrainfoSiteService(RcrainfoSiteRepository repository) {
        this.repository = repository;
    }

    public RcrainfoSite findByEpaId(String epaId) {
        return repository.findByEpaId(epaId)
                .orElseThrow(() -> new RcrainfoSiteNotFoundException(epaId));
    }

    public List<RcrainfoSite> findAll() {
        return this.repository.findAll();
    }

    public List<RcrainfoSite> findAllUserSites(String user) {
        return this.repository.findByUser(user);
    }
}
