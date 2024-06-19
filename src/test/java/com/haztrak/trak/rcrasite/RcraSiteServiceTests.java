package com.haztrak.trak.rcrasite;


import com.haztrak.trak.rcrasite.errors.RcraSiteNotFoundException;
import com.haztrak.trak.rcrasite.repository.RcraSiteRepository;
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

@SpringBootTest(classes = {RcraSiteService.class},webEnvironment= SpringBootTest.WebEnvironment.NONE)
public class RcraSiteServiceTests {

    @Autowired
    private RcraSiteService service;

    @MockBean
    private RcraSiteRepository repository;

    @Test
    @DisplayName("findByEpaId returns site when found")
    public void findByEpaIdReturnsSiteWhenFound() {
        String epaId = "good-site-id";
        RcraSite expectedSite = new RcraSite("foo", epaId);
        when(repository.findByEpaId(epaId)).thenReturn(Optional.of(expectedSite));
        RcraSite actualSite = service.findByEpaId(epaId);
        assertThat(actualSite).isEqualTo(expectedSite);
    }

    @Test
    @DisplayName("findByEpaId throws exception when not found")
    public void findByEpaIdThrowsExceptionWhenNotFound() {
        String epaId = "bad-site-id";
        when(repository.findByEpaId(epaId)).thenThrow(new RcraSiteNotFoundException(epaId));
        assertThrows(RcraSiteNotFoundException.class, () -> service.findByEpaId(epaId));
    }

    @Test
    @DisplayName("findAll returns all sites")
    public void findAllReturnsAllSites() {
        List<RcraSite> expectedSites = Arrays.asList(new RcraSite(), new RcraSite());
        when(repository.findAll()).thenReturn(expectedSites);
        List<RcraSite> actualSites = service.findAll();
        assertThat(actualSites).isEqualTo(expectedSites);
    }

    @Test
    @DisplayName("findAllUserSites returns sites for user")
    public void findAllUserSitesReturnsSitesForUser() {
        List<RcraSite> expectedSites = Arrays.asList(new RcraSite(), new RcraSite());
        String user = "user1";
        when(repository.findByUser(user)).thenReturn(expectedSites);
        List<RcraSite> actualSites = service.findAllUserSites(user);
        assertThat(actualSites).isEqualTo(expectedSites);
    }

    @Test
    @DisplayName("findAllUserSites returns empty list for unknown user")
    public void findAllUserSitesReturnsEmptyListForUnknownUser() {
        String unknownUser = "unknown-user";
        when(repository.findByUser(unknownUser)).thenReturn(Collections.emptyList());
        List<RcraSite> actualSites = service.findAllUserSites(unknownUser);
        assertThat(actualSites).isEmpty();
    }
}