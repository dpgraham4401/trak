package com.haztrak.trak.org;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class OrgRepositoryTests {

    @Autowired
    private OrgRepository orgRepository;

    @PostConstruct
    public void init() {
        Org org = new Org(1, "Test Org");
        Org childOrg1 = new Org(2, "child org 1");
        Org childOrg2 = new Org(3, "child Org 2");
        childOrg1.setParentOrg(org);
        childOrg2.setParentOrg(org);
        orgRepository.save(org);
        orgRepository.save(childOrg1);
        orgRepository.save(childOrg2);
    }

    @Test
    @DisplayName("findById returns an organization when found")
    public void findById() {
        Org org = orgRepository.findById(1).get();
        assertThat(org.getName()).isEqualTo("Test Org");
    }


    @Test
    @DisplayName("findAllSubOrgs returns a list of Orgs")
    public void findAllSubOrgs() {
        List<Org> subOrgs = orgRepository.findAllSubOrgs(1);
        assertThat(subOrgs.size()).isEqualTo(2);
        for (Org org : subOrgs) {
            assertThat(org.getParentOrg().getId()).isEqualTo(1);
        }
    }

}
