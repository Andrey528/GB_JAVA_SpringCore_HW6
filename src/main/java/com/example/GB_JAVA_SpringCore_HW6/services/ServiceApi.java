package com.example.GB_JAVA_SpringCore_HW6.services;

import com.example.GB_JAVA_SpringCore_HW6.models.Characters;

public interface ServiceApi {
    public Characters getAllCharacters();
    public Characters getCharactersByPageNumber(String page);
}