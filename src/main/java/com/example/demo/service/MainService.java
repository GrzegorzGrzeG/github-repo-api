package com.example.demo.service;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Repo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    private final RepoService repoService;
    private final BranchService branchService;

    public MainService(RepoService repoService, BranchService branchService) {
        this.repoService = repoService;
        this.branchService = branchService;
    }

    public List<Repo> resoResponse(String username) {
        return repoService.user(username);
    }

    public List<Branch> branchResponse(String username, String repo) {
        return branchService.getBranch(username, repo);

    }


    public List<Repo> response(String username) {
        List<Repo> repos = repoService.user(username);
        for (Repo repo: repos) {
            repo.setBranches(branchService.getBranch(username, repo.getName()));

        }
        return repos;
    }


}
