package com.example.GB_JAVA_SpringCore_HW6.controllers.rest;

import com.example.GB_JAVA_SpringCore_HW6.models.Characters;
import com.example.GB_JAVA_SpringCore_HW6.models.Result;
import com.example.GB_JAVA_SpringCore_HW6.services.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/data")
public class ControllerApi {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping
    public ResponseEntity<Characters> getCharacters()
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<Result> getCharacterById(@PathVariable Integer id) {
        Characters allCharacters = serviceApi.getAllCharacters();
        Optional<Result> character = allCharacters.getResults().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        if (character.isPresent()) {
            return new ResponseEntity<>(character.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}