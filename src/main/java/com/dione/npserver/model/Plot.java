package com.dione.npserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
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


    /**
     * A plot can have multiple characters, chapters, etc..
     * When in danger of recursion choose to display ID of Mapping
     * EntityMapping does not need to be shown in field notation
     **/
    @OneToMany(mappedBy = "plot") //this model maps the chapters
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonIgnore
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
