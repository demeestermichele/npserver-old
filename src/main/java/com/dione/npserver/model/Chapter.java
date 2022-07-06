package com.dione.npserver.model;

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

    public Chapter(String chapterName) {
        this.chapterName = chapterName;
    }

    public Chapter(Long id, String chapterName, Set<Character> charactersList) {
        this.chapterName = chapterName;
        this.charactersList = charactersList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
