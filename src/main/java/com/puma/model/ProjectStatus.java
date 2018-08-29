package com.puma.model;

import javax.persistence.*;

@Entity(name="PROJECT_STATUS")
public class ProjectStatus {

    @Id
    @Column(name = "PROJECT_STATUS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_status_seq")
    @SequenceGenerator(name = "project_status_seq", sequenceName = "project_status_seq", allocationSize = 1)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

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
}
