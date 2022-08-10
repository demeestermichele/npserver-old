package com.dione.npserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Plot")
public class Plot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private float revision;

    /** A chapter can have multiple characters and vice versa **/
    @OneToMany(mappedBy = "plot") //this model maps the chapters
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Set<EntityMapping> entityMapping;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRevision() {
        return revision;
    }

    public void setRevision(float revision) {
        this.revision = revision;
    }

    public Set<EntityMapping> getEntityMapping() {
        return entityMapping;
    }

    public void setEntityMapping(Set<EntityMapping> entityMapping) {
        this.entityMapping = entityMapping;
    }
}
