package com.haztrak.trak.org;

import com.haztrak.trak.org.errors.OrgNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    private final OrgRepository orgRepository;

    public OrgService(OrgRepository repository) {
        this.orgRepository = repository;
    }

    public Org findById(int orgId) {
        return orgRepository.findById(orgId).orElseThrow(() -> new OrgNotFoundException(orgId));
    }
}
