package com.example.GB_JAVA_SpringCore_HW6.services;

import com.example.GB_JAVA_SpringCore_HW6.models.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ServiceApiImpl implements ServiceApi{

    @Autowired
    private RestTemplate template;

    @Autowired
    private HttpHeaders headers;

    @Value("${character.api}")
    private String CHARACTER_API;
    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(CHARACTER_API, HttpMethod.GET, entity, Characters.class);

        return response.getBody();
    }

    @Override
    public Characters getCharactersByPageNumber(String page) {
        String uriString = UriComponentsBuilder.fromHttpUrl(CHARACTER_API)
                .queryParam("page", page)
                .toUriString(); // формируется строка URI с помощью UriComponentsBuilder, добавляя параметр "page" с переданным значением.
        headers.setAccept(List.of(MediaType.APPLICATION_JSON)); // устанавливаются заголовки запроса (Accept: application/json)
        HttpEntity<String > stringHttpEntity = new HttpEntity<>(headers);
        ResponseEntity<Characters> charactersResponseEntity = template.exchange(uriString, HttpMethod.GET,
                stringHttpEntity, Characters.class); // запрос к API
        return  charactersResponseEntity.getBody();
    }
}