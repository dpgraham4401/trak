package com.haztrak.trak.rcrasite.repository;

import com.haztrak.trak.rcrasite.RcraSite;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class RcraSiteQueryImpl implements RcraSiteQuery {

    private final EntityManager entityManager;

    @Autowired
    public RcraSiteQueryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Find all RcraSite entities for a given user.
     * This is an example of a custom query, currently does not work as the user entity has not been implemented.
     *
     * @param user String
     * @return List<RcraSite>
     */
    @Override
    public List<RcraSite> findByUser(String user) {
        TypedQuery<RcraSite> query = entityManager.createQuery(
                "SELECT r FROM RcraSite r", RcraSite.class);
        return query.getResultList();
    }
}
