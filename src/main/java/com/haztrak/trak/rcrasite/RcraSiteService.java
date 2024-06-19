package com.haztrak.trak.rcrasite;

import com.haztrak.trak.rcrasite.errors.RcraSiteNotFoundException;
import com.haztrak.trak.rcrasite.repository.RcraSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class RcraSiteService {

    private final RcraSiteRepository repository;

    @Autowired
    public RcraSiteService(RcraSiteRepository repository) {
        this.repository = repository;
    }

    public RcraSite findByEpaId(String epaId) {
        return repository.findByEpaId(epaId)
                .orElseThrow(() -> new RcraSiteNotFoundException(epaId));
    }

    public List<RcraSite> findAll() {
        return this.repository.findAll();
    }

    public List<RcraSite> findAllUserSites(String user) {
        return this.repository.findByUser(user);
    }
}
