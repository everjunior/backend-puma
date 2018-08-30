package com.puma.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity(name = "PROJECT_AREA_DESCRIPTION")
public class ProjectAreaDescription {

    @Id
    @Column(name = "PROJECT_AREA_DESCRIPTION_ID")
    @SequenceGenerator(name = "project_area_description_seq", sequenceName = "project_area_description_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "PROJECT_AREA_ID", referencedColumnName = "PROJECT_AREA_ID", nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private ProjectArea projectArea;

    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectArea getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(ProjectArea projectArea) {
        this.projectArea = projectArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
