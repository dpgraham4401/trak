package com.haztrak.trak.rcrainfosite;


import com.haztrak.trak.rcrainfosite.errors.RcrainfoSiteNotFoundException;
import com.haztrak.trak.rcrainfosite.repository.RcrainfoSiteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {RcrainfoSiteService.class},webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class RcrainfoSiteServiceTests {

    @Autowired
    private RcrainfoSiteService service;

    @MockBean
    private RcrainfoSiteRepository repository;

    @Test
    @DisplayName("findByEpaId returns site when found")
    public void findByEpaIdReturnsSiteWhenFound() {
        String epaId = "good-site-id";
        RcrainfoSite expectedSite = new RcrainfoSite("foo", epaId);
        when(repository.findByEpaId(epaId)).thenReturn(Optional.of(expectedSite));
        RcrainfoSite actualSite = service.findByEpaId(epaId);
        assertThat(actualSite).isEqualTo(expectedSite);
    }

    @Test
    @DisplayName("findByEpaId throws exception when not found")
    public void findByEpaIdThrowsExceptionWhenNotFound() {
        String epaId = "bad-site-id";
        when(repository.findByEpaId(epaId)).thenThrow(new RcrainfoSiteNotFoundException(epaId));
        assertThrows(RcrainfoSiteNotFoundException.class, () -> service.findByEpaId(epaId));
    }

    @Test
    @DisplayName("findAll returns all sites")
    public void findAllReturnsAllSites() {
        List<RcrainfoSite> expectedSites = Arrays.asList(new RcrainfoSite(), new RcrainfoSite());
        when(repository.findAll()).thenReturn(expectedSites);
        List<RcrainfoSite> actualSites = service.findAll();
        assertThat(actualSites).isEqualTo(expectedSites);
    }

    @Test
    @DisplayName("findAllUserSites returns sites for user")
    public void findAllUserSitesReturnsSitesForUser() {
        List<RcrainfoSite> expectedSites = Arrays.asList(new RcrainfoSite(), new RcrainfoSite());
        String user = "user1";
        when(repository.findByUser(user)).thenReturn(expectedSites);
        List<RcrainfoSite> actualSites = service.findAllUserSites(user);
        assertThat(actualSites).isEqualTo(expectedSites);
    }

    @Test
    @DisplayName("findAllUserSites returns empty list for unknown user")
    public void findAllUserSitesReturnsEmptyListForUnknownUser() {
        String unknownUser = "unknown-user";
        when(repository.findByUser(unknownUser)).thenReturn(Collections.emptyList());
        List<RcrainfoSite> actualSites = service.findAllUserSites(unknownUser);
        assertThat(actualSites).isEmpty();
    }
}