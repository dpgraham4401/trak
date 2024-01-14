package com.haztrak.trak.RcrainfoSite.repository;

import com.haztrak.trak.RcrainfoSite.entities.RcrainfoSite;

import java.util.List;

interface RcrainfoSiteQuery {

    List<RcrainfoSite> findByUser(String user);
}
