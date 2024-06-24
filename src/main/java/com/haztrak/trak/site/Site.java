package com.haztrak.trak.site;

import com.haztrak.trak.org.Org;
import jakarta.persistence.*;

public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "org")
    private Org org;

    public Site(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
