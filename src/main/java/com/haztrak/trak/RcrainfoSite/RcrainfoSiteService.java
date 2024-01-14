package com.haztrak.trak.RcrainfoSite;

import java.util.List;

public interface RcrainfoSiteService {
    RcrainfoSite findByEpaId(String epaId);

    List<RcrainfoSite> findAll();
}
