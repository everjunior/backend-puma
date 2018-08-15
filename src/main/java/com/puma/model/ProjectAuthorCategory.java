package com.puma.model;

import javax.persistence.*;

@Entity (name="PROJECT_AUTHOR_CATEGORY")
public class  ProjectAuthorCategory {
    @Id
    @Column(name = "PROJECT_AUTHOR_CATEGORY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_author_category_seq")
    @SequenceGenerator(name = "project_author_category_seq", sequenceName = "project_author_category_seq", allocationSize = 1)
    private Long id;

    @Column(name="DESCRIPTION", nullable = false)
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
