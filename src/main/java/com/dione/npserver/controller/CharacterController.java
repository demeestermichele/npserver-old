package com.dione.npserver.controller;

import com.dione.npserver.dto.CharacterDto;
import com.dione.npserver.dto.EntityMappingDto;
import com.dione.npserver.model.Character;
import com.dione.npserver.model.EntityMapping;
import com.dione.npserver.model.Role;
import com.dione.npserver.model.Sex;
import com.dione.npserver.repository.CharacterRepository;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/characters")
@CrossOrigin(origins = "*")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @PostMapping("/add")
    public String addCharacter(@RequestParam String first, @RequestParam String last, @RequestParam Role role, @RequestParam Sex sex) {
        Character character = new Character();
        character.setFirstName(first);
        character.setLastName(last);
        character.setRole(role);
        character.setSex(sex);
        characterRepository.save(character);
        return "Added new character to repo!";
    }

    @GetMapping("/list")
    public Iterable<Character> getCharacters() {
        return characterRepository.findAll();
    }


    @GetMapping("/{id}")
    public Character findCharacterById(@PathVariable Integer id) {
        return characterRepository.findCharacterById(id);
    }


    @GetMapping("/dto/{id}")
    public CharacterDto characterDto(@PathVariable Integer id) {
        Character character = characterRepository.findCharacterById(id);
        return new CharacterDto(character);
    }

// FIXME list is empty
    @GetMapping("/dto/list")
    public List<CharacterDto> getAllCharacterDtos() {
        Iterable<Character> characterList = characterRepository.findAll();
        List<CharacterDto> characterDtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(characterList, characterDtos);
        return characterDtos;
    }


    /**find all characters with the same mother id ***/
    @GetMapping("/{id}/children")
    public List<Character> getChildren(@PathVariable Integer id) {
        if (
                findCharacterById(id).getSex() == Sex.FEMALE
        ) {
            return characterRepository.findCharactersByMother(characterRepository.findCharacterById(id));
        } else if (
                findCharacterById(id).getSex() == Sex.MALE
        ) {
            return characterRepository.findCharactersByFather(characterRepository.findCharacterById(id));
        }else {
            return null;
        }

    }

}
