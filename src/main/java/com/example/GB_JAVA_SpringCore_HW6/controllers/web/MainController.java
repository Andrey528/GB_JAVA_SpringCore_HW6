package com.example.GB_JAVA_SpringCore_HW6.controllers.web;

import com.example.GB_JAVA_SpringCore_HW6.models.Characters;
import com.example.GB_JAVA_SpringCore_HW6.services.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping
    public String getCharacters(Model model) {
        Characters allCharacters = serviceApi.getAllCharacters();
        model.addAttribute("characters", allCharacters);
        return "main";
    }
}