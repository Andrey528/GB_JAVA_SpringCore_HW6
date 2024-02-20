package com.example.GB_JAVA_SpringCore_HW6.controllers.web;

import com.example.GB_JAVA_SpringCore_HW6.models.Characters;
import com.example.GB_JAVA_SpringCore_HW6.services.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.util.StringUtils;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping
    public String getCharacters(@RequestParam(required = false) String page, Model model) {
        Characters characters = StringUtils.isEmpty(page) ? serviceApi.getAllCharacters() :
                serviceApi.getCharactersByPageNumber(page);
        model.addAttribute("characters", characters);

        String prev = characters.getInfo().getPrev();
        String next = characters.getInfo().getNext();

        if (prev != null) {
            String prevPage = UriComponentsBuilder.fromUriString(prev).build().getQueryParams().get("page").get(0);
            model.addAttribute("prevPage", prevPage);
        }
        if (next != null) {
            String nextPage = UriComponentsBuilder.fromUriString(next).build().getQueryParams().get("page").get(0);
            model.addAttribute("nextPage", nextPage);
        }

        return "main";
    }
}