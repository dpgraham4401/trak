package com.haztrak.trak.rcrainfosite.repository;

import com.haztrak.trak.rcrainfosite.RcrainfoSite;

import java.util.List;

interface RcrainfoSiteQuery {

    List<RcrainfoSite> findByUser(String user);
}
