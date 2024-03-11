package com.haztrak.trak.rcrainfosite.repository;

import com.haztrak.trak.rcrainfosite.RcrainfoSite;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RcrainfoSiteRepository extends ListCrudRepository<RcrainfoSite, Integer>, RcrainfoSiteQuery {

    Optional<RcrainfoSite> findByEpaId(String epaId);
}
