package com.haztrak.trak.RcrainfoSite;

import com.haztrak.trak.RcrainfoSite.entities.RcrainfoSite;
import com.haztrak.trak.RcrainfoSite.errors.RcrainfoSiteErrorResponse;
import com.haztrak.trak.RcrainfoSite.errors.RcrainfoSiteNotFoundException;
import com.haztrak.trak.RcrainfoSite.services.RcrainfoSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RcrainfoSiteController {
    private final RcrainfoSiteService service;

    @Autowired
    RcrainfoSiteController(RcrainfoSiteService service) {
        this.service = service;
    }

    @GetMapping("site")
    ResponseEntity<List<RcrainfoSite>> findByEpaId() {
        List<RcrainfoSite> sites = service.findAll();
        return ResponseEntity.ok(sites);
    }

    @GetMapping("site/user")
    ResponseEntity<List<RcrainfoSite>> userSites() {
        List<RcrainfoSite> site = service.findAllUserSites("mockUser");
        if (site == null) {
            throw new RcrainfoSiteNotFoundException("mockUser");
        }
        return ResponseEntity.ok(site);
    }

    @GetMapping("site/{epaId}")
    ResponseEntity<RcrainfoSite> findByEpaId(@PathVariable String epaId) {
        RcrainfoSite site = service.findByEpaId(epaId);
        if (site == null) {
            throw new RcrainfoSiteNotFoundException(epaId);
        }
        return ResponseEntity.ok(site);
    }

    @ExceptionHandler
    ResponseEntity<RcrainfoSiteErrorResponse> handleRcrainfoSiteNotFound(RcrainfoSiteNotFoundException e) {
        RcrainfoSiteErrorResponse error = new RcrainfoSiteErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}
