package com.puma.model;

import javax.persistence.*;

@Entity(name = "PROJECT_AREA")
public class ProjectArea {

    @Id
    @Column(name = "PROJECT_AREA_ID")
    @SequenceGenerator(name = "project_area_seq", sequenceName = "project_area_seq", allocationSize = 1)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String description) {
        this.name = description;
    }
}
