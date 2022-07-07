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

    private String chapterName;

    @ManyToMany
    @JoinTable(
            name = "chapter_characters",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "chapter_id"))
    private Set<Character> charactersList;

    /**Constructors**/
    public Chapter() {

    }

    public Chapter(String chapterName) {
        this.chapterName = chapterName;
    }

    public Chapter(Long id, String chapterName, Set<Character> charactersList) {
        this.chapterName = chapterName;
        this.charactersList = charactersList;
    }

    /**Getters and Setters**/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Set<Character> getCharactersList() {
        return charactersList;
    }

    public void setCharactersList(Set<Character> charactersList) {
        this.charactersList = charactersList;
    }
    /**To String**/
    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", chapterName='" + chapterName + '\'' +
                ", charactersList=" + charactersList +
                '}';
    }
}
