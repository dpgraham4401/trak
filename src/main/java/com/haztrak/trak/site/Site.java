package com.haztrak.trak.site;

import com.haztrak.trak.org.Org;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final String id;

    @Column(name = "name")
    private final String name;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @NonNull
    @JoinColumn(name = "org")
    private final Org org;

    public Site(String id, String name, @NonNull Org org) {
        this.id = id;
        this.name = name;
        this.org = org;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Org getOrg() {
        return org;
    }
}
