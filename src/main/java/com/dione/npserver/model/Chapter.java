package com.dione.npserver.model;
/**Chapter model by demeestermichele**/

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

    private float number;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "chapter_characters",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "chapter_id"))
    private List<Character> charactersList;

    /**Constructors**/
    public Chapter() {
    }

    public Chapter(Long id) {
        this.id = id;
    }

    public Chapter(Long id, String name, float number, String description, List<Character> charactersList) {
        this.id = id;
        this.name = name;
        this.number = number;
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

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
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
                ", description='" + description + '\'' +
                ", charactersList=" + charactersList +
                '}';
    }
}
