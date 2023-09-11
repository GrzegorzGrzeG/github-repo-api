package com.example.demo.controller;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Repo;
import com.example.demo.service.MainService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping("/repo/{username}")
    public List<Repo> repos(@PathVariable("username") String username) {
        return mainService.resoResponse(username);
    }

    @RequestMapping("/branch/{username}/{repo}")
    public List<Branch> branches(@PathVariable("username") String username, @PathVariable("repo") String repo) {
        return mainService.branchResponse(username, repo);
    }


    @RequestMapping("/{username}")
    public List<Repo> mainResponse(@PathVariable("username") String username) {
        return mainService.response(username);
    }

}
