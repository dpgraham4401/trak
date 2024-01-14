package com.haztrak.trak.RcrainfoSite;

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
        return repository.findByEpaId(epaId);
    }

    @Override
    public List<RcrainfoSite> findAll() {
        return repository.findAll();
    }
}
