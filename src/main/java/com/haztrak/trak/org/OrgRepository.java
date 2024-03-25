package com.haztrak.trak.org;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrgRepository extends CrudRepository<Org, Integer> {

    @Query("SELECT o FROM Org o WHERE o.parentOrg.id = :orgId")
    List<Org> findAllSubOrgs(int orgId);
}
