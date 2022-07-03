package com.dione.npserver.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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

    @ManyToOne
    @JoinColumn(name = "mother", nullable = true)
    private Character mother;

    @ManyToOne
    @JoinColumn(name = "father", nullable = true)
    private Character father;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Character> kids;

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

    public Collection<Character> getKids() {
        return kids;
    }

    public void setKids(Collection<Character> children) {
        this.kids = children;
    }

    public Character() {
    }

    public Character(Integer id, String firstName, String lastName, Sex sex, Role role, Character mother, Character father, Collection<Character> kids) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.role = role;
        this.mother = mother;
        this.father = father;
        this.kids = kids;
    }

    public Character(Integer id) {
        this.id = id;
    }


}
