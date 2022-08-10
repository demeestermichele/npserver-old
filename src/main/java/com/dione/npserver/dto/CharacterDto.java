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
    private final Sex sex;
    private final Role chartype;
    private final Set<EntityMapping> entityMappingList;

    public CharacterDto(Character character) {
        this.id = character.getId();
        this.firstName = character.getFirstName();
        this.lastName = character.getLastName();
        this.sex = character.getSex();
        this.chartype = getChartype();
        //FIXME this should be dto not entity
        this.entityMappingList = character.getEntityMapping();
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public Role getChartype() {
        return chartype;
    }

    public Set<EntityMapping> getEntityMappingList() {
        return entityMappingList;
    }
}
