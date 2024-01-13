package com.haztrak.trak.RcrainfoSite;

import org.springframework.data.jpa.repository.JpaRepository;

interface RcrainfoSiteRepository extends JpaRepository<RcrainfoSite, Integer> {

    RcrainfoSite findByEpaId(String epaId);
}
