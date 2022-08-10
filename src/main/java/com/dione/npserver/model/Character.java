/**Character model by demeestermichele**/
package com.dione.npserver.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Character")
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private Sex sex;
    private Role role;

    /** One mother (character.Sex == FEMALE) can have multiple children **/
    @ManyToOne
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JoinColumn(name = "mother", nullable = true)
    private Character mother;

    /** One father (character.Sex == MALE) can have many children **/
    @ManyToOne
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JoinColumn(name = "father", nullable = true)
    private Character father;

    //TODO relate to character/plot via EntityMapping
    /** A chapter can have multiple characters and vice versa **/
    @OneToMany(mappedBy = "character", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //this model maps the chapters
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private Set<EntityMapping> entityMapping;

    /**Constructors**/
    public Character() { }

    public Character(Integer id) {
        this.id = id;
    }

    public Character(Integer id, String firstName, String lastName, Sex sex, Role role, Character mother, Character father) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.role = role;
        this.mother = mother;
        this.father = father;
    }

    /**Getters and setters**/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Character getMother() {
        return mother;
    }

    public void setMother(Character mother) {
        this.mother = mother;
    }

    public Character getFather() {
        return father;
    }

    public void setFather(Character father) {
        this.father = father;
    }

    public Set<EntityMapping> getEntityMapping() {
        return entityMapping;
    }

    public void setEntityMapping(Set<EntityMapping> entityMapping) {
        this.entityMapping = entityMapping;
    }

    /**ToString**/
    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", role=" + role +
                ", mother=" + mother +
                ", father=" + father +
                '}';
    }
}
