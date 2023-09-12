package com.example.demo.controller;

import com.example.demo.entity.Repo;
import com.example.demo.exception.ApiError;
import com.example.demo.service.MainService;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final MainService mainService;
    private final UserService userService;


    public MainController(MainService mainService, UserService userService) {
        this.mainService = mainService;
        this.userService = userService;
    }

    @RequestMapping(value = "/{username}")
    public ResponseEntity<Object> mainResponse(@PathVariable("username") String username, @RequestHeader("Accept") String acceptHeader) {
        ApiError apiError = new ApiError();

        if (acceptHeader.equals("application/json")) {
            List<Repo> repos = mainService.response(username);
            if (!userService.checkIfUserExists(username)) {
                apiError.setHttpStatus(404);
                apiError.setMessage("User does not exist");
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(apiError);
            }
            return ResponseEntity.ok(repos);
        }
        apiError.setHttpStatus(406);
        apiError.setMessage("Wrong response format");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(apiError);
    }

}
