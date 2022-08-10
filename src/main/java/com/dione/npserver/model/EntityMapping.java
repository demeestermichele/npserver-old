package com.dione.npserver.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Entity_mapping")
public class EntityMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**One character can appear in a chapter/plots and vice versa **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    /*@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")*/
    @PrimaryKeyJoinColumn(name="character_id", referencedColumnName="id")
    private Character character;

    /** A chapter can have multiple characters/plots and vice versa **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    /*@JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")*/
    @PrimaryKeyJoinColumn(name="chapter_id", referencedColumnName="id")
    private Chapter chapter;

    /** A plot can have multiple characters/chapters and vice versa **/
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
   /* @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")*/
    @PrimaryKeyJoinColumn(name="plot_id", referencedColumnName="id")
    private Plot plot;

    public EntityMapping() {
    }

    public EntityMapping(Character character, Chapter chapter, Plot plot) {
        this.character = character;
        this.chapter = chapter;
        this.plot = plot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }
}
