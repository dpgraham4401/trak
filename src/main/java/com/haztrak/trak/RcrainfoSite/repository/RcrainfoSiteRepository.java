package com.haztrak.trak.RcrainfoSite.repository;

import com.haztrak.trak.RcrainfoSite.entities.RcrainfoSite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RcrainfoSiteRepository extends JpaRepository<RcrainfoSite, Integer>, RcrainfoSiteQuery {

    Optional<RcrainfoSite> findByEpaId(String epaId);
}
