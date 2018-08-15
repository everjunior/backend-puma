package com.puma.model;

import javax.persistence.*;

@Entity(name = "PROJECT_AREA")
public class ProjectArea {

    @Id
    @Column(name = "PROJECT_AREA_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_area_seq")
    @SequenceGenerator(name = "project_area_seq", sequenceName = "project_area_seq", allocationSize = 1)
    private Long id;

    @Column(name = "PSP", nullable = false)
    private Long psp;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPsp() {
        return psp;
    }

    public void setPsp(Long psp) {
        this.psp = psp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
