package com.haztrak.trak.rcrasite.repository;

import com.haztrak.trak.rcrasite.RcraSite;

import java.util.List;

interface RcraSiteQuery {

    List<RcraSite> findByUser(String user);
}
