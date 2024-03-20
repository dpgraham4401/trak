package com.haztrak.trak.rcrainfosite.repository;

import com.haztrak.trak.rcrainfosite.RcrainfoSite;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class RcrainfoSiteQueryImpl implements RcrainfoSiteQuery {

    private final EntityManager entityManager;

    @Autowired
    public RcrainfoSiteQueryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Find all RcrainfoSite entities for a given user.
     * This is an example of a custom query, currently does not work as the user entity has not been implemented.
     *
     * @param user String
     * @return List<RcrainfoSite>
     */
    @Override
    public List<RcrainfoSite> findByUser(String user) {
        TypedQuery<RcrainfoSite> query = entityManager.createQuery(
                "SELECT r FROM RcrainfoSite r", RcrainfoSite.class);
        return query.getResultList();
    }
}
