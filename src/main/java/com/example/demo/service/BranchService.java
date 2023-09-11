package com.example.demo.service;

import com.example.demo.entity.Branch;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BranchService {
    private final String branchURL = "https://api.github.com/repos/{username}/{repo}/branches";
    private final RestTemplate restTemplate;

    public BranchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Branch> getBranch(String username, String repo){
        String resutlURL = branchURL.replace("{username}", username).replace("{repo}",repo);
        ResponseEntity<Branch[]> responseEntity = restTemplate.getForEntity(resutlURL, Branch[].class);
        Branch[] branches = responseEntity.getBody();
        return Arrays.asList(branches);
    }
}
