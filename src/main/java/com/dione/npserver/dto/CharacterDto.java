package com.dione.npserver.dto;

import com.dione.npserver.model.Character;
import lombok.Data;

@Data
public class CharacterDto {
    private Integer id;
    private String firstName;
    private String lastName;

    public CharacterDto(Character entity){
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
    }
}
    /*Student student = repository.findAllById("123L");
    StudentDto studentDto = new StudentDto(student);*/
