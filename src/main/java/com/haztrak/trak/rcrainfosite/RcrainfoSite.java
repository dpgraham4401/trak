package com.haztrak.trak.rcrainfosite;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

@Entity
@Table(name = "rcrainfo_site")
public class RcrainfoSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "epa_id")
    private String epaId;
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    @JsonSerialize(using = SiteTypeSerializer.class)
    private SiteType type;

    @Column(name = "gis_primary", nullable = false)
    private Boolean gisPrimary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mailing_address_id")
    private Address mailingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "site_address_id")
    private Address siteAddress;

    public RcrainfoSite() {
    }

    public Address getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(Address siteAddress) {
        this.siteAddress = siteAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
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

    public SiteType getType() {
        return type;
    }

    public void setType(SiteType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Boolean getGisPrimary() {
        return gisPrimary;
    }

    public void setGisPrimary(Boolean gisPrimary) {
        this.gisPrimary = gisPrimary;
    }
}
