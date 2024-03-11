package com.haztrak.trak.org;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST endpoint for the organization entity.
 */
@RestController
@RequestMapping("/api/org")
public class OrgController {

    @GetMapping("")
    public String getOrg() {
        return "org";
    }

}
