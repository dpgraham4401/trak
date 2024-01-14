package com.haztrak.trak.RcrainfoSite.services;

import com.haztrak.trak.RcrainfoSite.entities.RcrainfoSite;
import com.haztrak.trak.RcrainfoSite.errors.RcrainfoSiteNotFoundException;
import com.haztrak.trak.RcrainfoSite.repository.RcrainfoSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RcrainfoServiceImpl implements RcrainfoSiteService {

    private final RcrainfoSiteRepository repository;

    @Autowired
    public RcrainfoServiceImpl(RcrainfoSiteRepository repository) {
        this.repository = repository;
    }

    @Override
    public RcrainfoSite findByEpaId(String epaId) {
        return repository.findByEpaId(epaId)
                .orElseThrow(() -> new RcrainfoSiteNotFoundException(epaId));
    }

    @Override
    public List<RcrainfoSite> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<RcrainfoSite> findAllUserSites(String user) {
        return this.repository.findByUser(user);
    }
}
