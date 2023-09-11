package com.example.demo.controller;

import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class MainController {

    private final String url = "https://api.github.com/users/{username}/repos";
    private final String url1 = "https://api.github.com/users/{username}";

    @Autowired
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;

    @RequestMapping("/{username}")
    public List<User> users(@PathVariable("username") String username) throws IOException {
//        httpHeaders.set("Content-Type", "application/json");
        String resultURL = url.replace("{username}", username);
        ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(resultURL, User[].class);
        User[] users = responseEntity.getBody();
        return Arrays.asList(users);
    }

}
