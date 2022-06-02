package com.dione.npserver.controller;
import com.dione.npserver.model.Character;
import com.dione.npserver.model.Sex;
import com.dione.npserver.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @PostMapping("/add")
    public String addCharacter(@RequestParam String first, @RequestParam String last, @RequestParam Sex sex) {
        Character character = new Character();
        character.setFirstName(first);
        character.setLastName(last);
        character.setSex(sex);
        characterRepository.save(character);
        return "Added new character to repo!";
    }

    @GetMapping("/character-list")
    public Iterable<Character> getCharacter() {
        return characterRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Character findCharacterById(@PathVariable Integer id) {
        return characterRepository.findCharacterById(id);
    }

    @GetMapping("/search-firstname/{firstName}")
    public Character findCharacterByFirstName(@PathVariable String firstName) {
        return characterRepository.findCharactersByFirstName(firstName);
    }

}
