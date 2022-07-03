package com.dione.npserver;

import com.dione.npserver.controller.CharacterController;
import com.dione.npserver.model.Character;
import com.dione.npserver.model.Role;
import com.dione.npserver.model.Sex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NpserverApplication {


    static CharacterController characterController = new CharacterController();



    public static void main(String[] args) {
        SpringApplication.run(NpserverApplication.class, args);

        characterController.addCharacter("Homer", "Simpson", Sex.MALE, null, null, Role.ANTAGONIST);
        characterController.addCharacter("Marge", "Simpson", Sex.FEMALE, null, null, Role.PROTAGONIST);
      /*  characterController.addCharacter("Lisa", "Simpson", Sex.FEMALE, characterController.findCharacterById(2), characterController.findCharacterById(1), Role.BACKGROUND);
        characterController.addCharacter("Bart", "Simpson", Sex.FEMALE, characterController.findCharacterById(2), characterController.findCharacterById(1), Role.SIDE);
        characterController.addCharacter("Maggie", "Simpson", Sex.FEMALE, characterController.findCharacterById(2), characterController.findCharacterById(1), Role.THROWAWAY);
*/
    }


    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


}
