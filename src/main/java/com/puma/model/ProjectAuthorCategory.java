package com.puma.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity (name="PROJECT_AUTHOR_CATEGORY")
public class  ProjectAuthorCategory {
    public enum ProjectAuthorCategoryDescription { PESSOA_FISICA, PESSOA_JURIDICA }

    @Id
    @Column(name = "PROJECT_AUTHOR_CATEGORY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_author_category_seq")
    @SequenceGenerator(name = "project_author_category_seq", sequenceName = "project_author_category_seq", allocationSize = 1)
    private Long id;

    @Column(name="DESCRIPTION", nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private ProjectAuthorCategoryDescription description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectAuthorCategoryDescription getDescription() {
        return description;
    }

    public void setDescription(ProjectAuthorCategoryDescription description) {
        this.description = description;
    }
}
