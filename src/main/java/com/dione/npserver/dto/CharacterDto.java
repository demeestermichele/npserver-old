package com.dione.npserver.dto;

import com.dione.npserver.model.*;
import com.dione.npserver.model.Character;
import lombok.Data;

import java.util.*;

import java.io.Serializable;

@Data
public class CharacterDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private Integer mother;
    private Integer father;
    private final Sex sex;
    private final Role role;

    /*    unless this can refer to the entity dto, this defeats the purpose of having a character DTO*/
//    private Set<EntityMapping> entityMappingDtoList;

    public CharacterDto(Character character) {
        this.id = character.getId();
        this.firstName = character.getFirstName();
        this.lastName = character.getLastName();
        try {
            this.mother = character.getMother().getId();
                } catch (NullPointerException n) {
                    System.out.println("No mother ID found");
                }
        try {
            this.father = character.getFather().getId();
                } catch (NullPointerException n) {
                    System.out.println("No father ID found");
                }
        this.sex = character.getSex();
        this.role = character.getRole();
    }

}
