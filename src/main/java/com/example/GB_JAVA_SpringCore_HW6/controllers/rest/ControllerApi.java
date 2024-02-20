package com.example.GB_JAVA_SpringCore_HW6.controllers.rest;

import com.example.GB_JAVA_SpringCore_HW6.models.Characters;
import com.example.GB_JAVA_SpringCore_HW6.models.Result;
import com.example.GB_JAVA_SpringCore_HW6.services.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

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
    public ResponseEntity<Result> getCharacterById(@PathVariable Integer id, @RequestParam(required = false) String page) {
        System.out.println(page);
        Characters allCharacters = StringUtils.isEmpty(page) ? serviceApi.getAllCharacters() :
                serviceApi.getCharactersByPageNumber(page);
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