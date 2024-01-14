package com.haztrak.trak.RcrainfoSite.services;

import com.haztrak.trak.RcrainfoSite.entities.RcrainfoSite;

import java.util.List;

public interface RcrainfoSiteService {
    RcrainfoSite findByEpaId(String epaId);

    List<RcrainfoSite> findAll();

    List<RcrainfoSite> findAllUserSites(String user);
}
