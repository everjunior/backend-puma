package com.puma.model;

import javax.persistence.*;

@Entity(name = "PROJECT_AREA")
public class ProjectArea {

    @Id
    @Column(name = "PROJECT_AREA_ID")
    @SequenceGenerator(name = "project_area_seq", sequenceName = "project_area_seq", allocationSize = 1)
    private Long id;

    @Column(name = "PSP", nullable = false)
    private Long psp;

    @Column(name = "name", nullable = false)
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }
}
