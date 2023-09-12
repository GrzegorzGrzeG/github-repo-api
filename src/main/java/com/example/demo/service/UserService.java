package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final String branchURL = "https://api.github.com/users/{username}";
    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean checkIfUserExists(String username) {
        String resultURL = branchURL.replace("{username}", username);
        try {
            restTemplate.getForEntity(resultURL, User.class);
            return true;
        } catch (HttpClientErrorException.NotFound e) {
            return false;
        }
    }

}
