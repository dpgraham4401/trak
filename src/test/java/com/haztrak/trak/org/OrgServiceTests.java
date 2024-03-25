package com.haztrak.trak.org;

import com.haztrak.trak.org.errors.OrgNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@WebMvcTest(OrgService.class)
public class OrgServiceTests {
    @Autowired
    private OrgService service;

    @MockBean
    private OrgRepository repository;

    @Test
    @DisplayName("findById returns an organization when found")
    public void findByOrgID() {
        int orgId = 1;
        Org expectedOrg = new Org(orgId, "foo");
        when(repository.findById(orgId)).thenReturn(Optional.of(expectedOrg));
        Org returnedOrg = service.findById(orgId);
        assertThat(returnedOrg).isEqualTo(expectedOrg);
    }

    @Test
    @DisplayName("findById throws an exception when organization not found")
    public void findByOrgIDThrowsNotFoundException() {
        int orgId = 1;
        when(repository.findById(orgId)).thenThrow(new OrgNotFoundException(orgId));
        assertThrows(OrgNotFoundException.class, () -> service.findById(orgId));
    }

    @Test
    @DisplayName("findAllSubOrgs returns an empty list when no sub-organizations found")
    public void findAllSubOrgsReturnsEmpty() {
        int orgId = 1;
        when(repository.findAllSubOrgs(orgId)).thenReturn(new ArrayList<Org>());
        assertThat(service.findAllSubOrgs(orgId)).isEmpty();
    }

    @Test
    @DisplayName("findAllSubOrgs returns a list of Orgs")
    public void findAllSubOrgsReturnsAList() {
        int orgId = 1;
        Org parentOrg = new Org(orgId, "foo");
        Org childOrg1 = new Org(2, "bar");
        Org childOrg2 = new Org(3, "baz");
        when(repository.findAllSubOrgs(orgId)).thenReturn(new ArrayList<Org>(
                List.of(childOrg1, childOrg2)
        ));
        List<Org> subOrgs = service.findAllSubOrgs(orgId);
        assertThat(subOrgs.size()).isEqualTo(2);
        assertThat(subOrgs).contains(childOrg1, childOrg2);
    }
}
