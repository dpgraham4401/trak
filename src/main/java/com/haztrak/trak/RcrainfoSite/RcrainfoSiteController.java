package com.haztrak.trak.RcrainfoSite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RcrainfoSiteController {
    private final RcrainfoSiteRepository repository;

    RcrainfoSiteController(RcrainfoSiteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("site")
    List<RcrainfoSite> findByEpaId() {
        return repository.findAll();
    }

    @GetMapping("site/{epaId}")
    RcrainfoSite findByEpaId(@PathVariable String epaId) {
        return repository.findByEpaId(epaId);
    }
}
