package com.example.demo.service;

import com.example.demo.entity.Repo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RepoService {
    private final String userURL = "https://api.github.com/users/{username}/repos";
    private final String urlMain = "https://api.github.com/users/{username}";

    private final RestTemplate restTemplate;
    private final BranchService branchService;


    public RepoService(RestTemplate restTemplate, BranchService branchService) {
        this.restTemplate = restTemplate;
        this.branchService = branchService;
    }

    //    private final HttpHeaders httpHeaders;
    public List<Repo> user(String username) {
        List<Repo> result = new ArrayList<>();
        String resultURL = userURL.replace("{username}", username);
        ResponseEntity<Repo[]> responseEntity = restTemplate.getForEntity(resultURL, Repo[].class);
        Repo[] repos = responseEntity.getBody();
        List<Repo> repoList = Arrays.asList(repos);
        for (Repo repo: repoList) {
            if(!repo.isFork()){
                result.add(repo);
            }
        }
        return result;
    }

}
