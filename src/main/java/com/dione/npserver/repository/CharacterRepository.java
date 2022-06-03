package com.dione.npserver.repository;

import com.dione.npserver.model.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {
    public Character findCharacterById(Integer id);
    public Character findCharactersByFirstName(String firstName);
    public Character findCharactersByLastName(String lastName);
    public Character findCharactersByMother(String firstName);
}
