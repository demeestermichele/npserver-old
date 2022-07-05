package com.dione.npserver.repository;

import com.dione.npserver.model.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterRepository extends CrudRepository<Character, Integer> {
    public Character findCharacterById(Integer id);
    public Character findCharactersByFirstName(String firstName);
    public Character findCharactersByLastName(String lastName);
    public List<Character> findCharactersByMother(Character mother);
    public List<Character> findCharactersByFather(Character father);
    public List<Character> findCharactersByMotherOrFather(Character parent);
}
