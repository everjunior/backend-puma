package com.puma.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @Column(name = "PROJECT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
    private Long id;

    @Column(name = "PROJECT_TITLE", nullable = false)
    private String title;

    @Column(name = "SUMMARY", columnDefinition = "TEXT", nullable = false)
    private String summary;

    @Column(name = "BODY", columnDefinition = "TEXT", nullable = false)
    private String body;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "USER_ID", nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = User.class)
    @JsonIdentityReference(alwaysAsId = true)
    private User author;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ProjectAuthorCategory.class)
    @JoinColumn(name = "PROJECT_AUTHOR_CATEGORY_ID", referencedColumnName = "PROJECT_AUTHOR_CATEGORY_ID", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private ProjectAuthorCategory projectAuthorCategory;

    @Column(name="cnpj")
    private String cnpj;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ProjectStatus.class)
    @JoinColumn(name = "PROJECT_STATUS_ID", referencedColumnName = "PROJECT_STATUS_ID", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private ProjectStatus projectStatus;

    @Column(name = "answer")
    private String answer;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ProjectArea.class)
    @JoinColumn(name = "PROJECT_AREA_ID", referencedColumnName = "PROJECT_AREA_ID", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private ProjectArea projectArea;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ProjectAreaDescription.class)
    @JoinColumn(name = "PROJECT_AREA_DESCRIPTION_ID", referencedColumnName = "PROJECT_AREA_DESCRIPTION_ID", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)
    private ProjectAreaDescription projectAreaDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createDate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public ProjectAuthorCategory getProjectAuthorCategory() {
        return projectAuthorCategory;
    }

    public void setProjectAuthorCategory(ProjectAuthorCategory projectAuthorCategory) {
        this.projectAuthorCategory = projectAuthorCategory;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ProjectArea getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(ProjectArea projectArea) {
        this.projectArea = projectArea;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ProjectAreaDescription getProjectAreaDescription() {
        return projectAreaDescription;
    }

    public void setProjectAreaDescription(ProjectAreaDescription projectAreaDescription) {
        this.projectAreaDescription = projectAreaDescription;
    }
}
