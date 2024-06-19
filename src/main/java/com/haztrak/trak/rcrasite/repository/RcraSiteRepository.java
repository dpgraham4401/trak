package com.haztrak.trak.rcrasite.repository;

import com.haztrak.trak.rcrasite.RcraSite;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RcraSiteRepository extends ListCrudRepository<RcraSite, Integer>, RcraSiteQuery {

    Optional<RcraSite> findByEpaId(String epaId);
}
