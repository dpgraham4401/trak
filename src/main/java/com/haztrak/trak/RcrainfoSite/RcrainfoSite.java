package com.haztrak.trak.RcrainfoSite;

import jakarta.persistence.*;

@Entity
@Table(name = "rcrainfo_site")
public class RcrainfoSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "epa_id")
    private String epaId;
    @Column(name = "name")
    private String name;


    public RcrainfoSite() {
    }

    public RcrainfoSite(String name, String epaId) {
        this.name = name;
        this.epaId = epaId;
    }

    public String getEpaId() {
        return this.epaId;
    }

    public void setEpaId(String epaId) {
        this.epaId = epaId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
