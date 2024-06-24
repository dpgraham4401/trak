package com.haztrak.trak.site;

import com.haztrak.trak.org.Org;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @NonNull
    @JoinColumn(name = "org")
    private Org org;

    public Site() {
    }


    public Site(String name, @NonNull Org org) {
        this.name = name;
        this.org = org;
    }

    public Site(String name, @NonNull Org org, String id) {
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
