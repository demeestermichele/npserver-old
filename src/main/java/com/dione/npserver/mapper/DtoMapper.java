package com.dione.npserver.mapper;

import com.dione.npserver.dto.CharacterDto;
import com.dione.npserver.model.Character;
import org.modelmapper.ModelMapper;

public class DtoMapper {


    static void mapCharacter() {
        Character character = new Character();
        ModelMapper modelMapper = new ModelMapper();
        CharacterDto characterDto = modelMapper.map(character, CharacterDto.class);
    }

}
