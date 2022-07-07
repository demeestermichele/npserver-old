/**Chapter model by demeestermichele**/
package com.dione.npserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Chapter")
public class Chapter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer number;

    private float version;

    private String description;

    @ManyToMany
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JoinTable(
            name = "chapter_characters",
            joinColumns = @JoinColumn(name = "chapter_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private List<Character> charactersList;

    /**Constructors**/
    public Chapter() {
    }

    public Chapter(Long id) {
        this.id = id;
    }

    public Chapter(Long id, String name, Integer number, float version, String description, List<Character> charactersList) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.version = version;
        this.description = description;
        this.charactersList = charactersList;
    }

    /**Getters and Setters**/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Character> getCharactersList() {
        return charactersList;
    }

    public void setCharactersList(List<Character> charactersList) {
        this.charactersList = charactersList;
    }

    /**To String**/
    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", version=" + version +
                ", description='" + description + '\'' +
                ", charactersList=" + charactersList +
                '}';
    }
}
