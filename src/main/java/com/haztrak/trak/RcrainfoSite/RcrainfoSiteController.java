package com.haztrak.trak.RcrainfoSite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    List<RcrainfoSite> findByEpaId() {
        return service.findAll();
    }

    @GetMapping("site/{epaId}")
    RcrainfoSite findByEpaId(@PathVariable String epaId) {
        return service.findByEpaId(epaId);
    }
}
