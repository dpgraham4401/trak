package com.haztrak.trak.org;

import com.haztrak.trak.org.errors.OrgNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class OrgService {

    private final OrgRepository orgRepository;

    @Autowired
    public OrgService(OrgRepository repository) {
        this.orgRepository = repository;
    }

    public Org findById(int orgId) {
        return orgRepository.findById(orgId).orElseThrow(() -> new OrgNotFoundException(orgId));
    }

    public List<Org> findAllSubOrgs(int orgId) {
        return orgRepository.findAllSubOrgs(orgId);
    }
}
