package com.dione.npserver.model;
/**Character model by demeestermichele**/
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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
    @JoinColumn(name = "mother", nullable = true)
    private Character mother;

    /** One father (character.Sex == MALE) can have many children **/
    @ManyToOne
    @JoinColumn(name = "father", nullable = true)
    private Character father;

    /** One chapter can have multiple characters and vice versa **/
    @ManyToMany(mappedBy = "charactersList")
    private Set<Chapter> chaptersList;

    /**Constructors**/
    public Character() {
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
    public Character(Integer id) {
        this.id = id;
    }
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

    public Set<Chapter> getChaptersList() {
        return chaptersList;
    }

    public void setChaptersList(Set<Chapter> chaptersList) {
        this.chaptersList = chaptersList;
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
