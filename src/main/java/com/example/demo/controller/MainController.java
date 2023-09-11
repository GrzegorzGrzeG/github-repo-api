package com.example.demo.controller;

import com.example.demo.entity.Repo;
import com.example.demo.exception.NoSuchFormatException;
import com.example.demo.service.MainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    private final MainService mainService;


    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping(value = "/{username}")
    public ResponseEntity<Object> mainResponse(@PathVariable("username") String username, @RequestHeader("Accept") String acceptHeader) {
        if (!acceptHeader.equals("application/json")) {
           throw new NoSuchFormatException("Wrong format Exception");
        }

        List<Repo> repos = mainService.response(username);
        return ResponseEntity.ok(repos);
    }

}
