package com.dione.npserver.controller;
import com.dione.npserver.model.Character;
import com.dione.npserver.model.Role;
import com.dione.npserver.model.Sex;
import com.dione.npserver.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
@CrossOrigin(origins = "*")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @PostMapping("/add")
    public String addCharacter(@RequestParam String first, @RequestParam String last, @RequestParam Sex sex, @RequestParam Character mother, @RequestParam Character father, @RequestParam Role role) {
        Character character = new Character();
        character.setFirstName(first);
        character.setLastName(last);
        character.setRole(role);
        character.setSex(sex);
        character.setMother(mother);
        character.setFather(father);
        characterRepository.save(character);
        return "Added new character to repo!";
    }

    @GetMapping("/list")
    public Iterable<Character> getCharacter() {
        return characterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Character findCharacterById(@PathVariable Integer id) {
        return characterRepository.findCharacterById(id);
    }


}
