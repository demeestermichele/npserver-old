package com.dione.npserver.dto;

import com.dione.npserver.model.Role;
import com.dione.npserver.model.Sex;
import lombok.Data;

import java.io.Serializable;

@Data
public class CharacterDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Sex sex;
    private final Role chartype;
    private final com.dione.npserver.dto.CharacterDto mother;
    private final com.dione.npserver.dto.CharacterDto father;
}
