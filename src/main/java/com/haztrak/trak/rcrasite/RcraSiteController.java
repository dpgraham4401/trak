package com.haztrak.trak.rcrasite;

import com.haztrak.trak.rcrasite.errors.RcraSiteErrorResponse;
import com.haztrak.trak.rcrasite.errors.RcraSiteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/site")
public class RcraSiteController {
    private final RcraSiteService service;

    @Autowired
    RcraSiteController(RcraSiteService rcraSiteService) {
        service = rcraSiteService;
    }

    @GetMapping("")
    ResponseEntity<List<RcraSite>> findByEpaId() {
        List<RcraSite> sites = service.findAll();
        return ResponseEntity.ok(sites);
    }

    @GetMapping("/user")
    ResponseEntity<List<RcraSite>> userSites() {
        List<RcraSite> site = service.findAllUserSites("mockUser");
        if (site == null) {
            throw new RcraSiteNotFoundException("mockUser");
        }
        return ResponseEntity.ok(site);
    }

    @GetMapping("/{epaId}")
    ResponseEntity<RcraSite> findByEpaId(@PathVariable String epaId) {
        RcraSite site = service.findByEpaId(epaId);
        if (site == null) {
            throw new RcraSiteNotFoundException(epaId);
        }
        return ResponseEntity.ok(site);
    }

    @ExceptionHandler
    ResponseEntity<RcraSiteErrorResponse> handleRcraSiteNotFound(RcraSiteNotFoundException e) {
        RcraSiteErrorResponse error = new RcraSiteErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}
