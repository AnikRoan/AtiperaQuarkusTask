package com.roananik.service;
import com.roananik.pojo.BranchInfo;
import com.roananik.pojo.RepositoryName;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.kohsuke.github.GHFileNotFoundException;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GitHubService {
    private GitHub gitHub;

    @PostConstruct
    public void init() {
        try {
            gitHub = GitHub.connectAnonymously();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RepositoryName> getRepositories(String name) throws GHFileNotFoundException {
        try {
            GHUser user = gitHub.getUser(name);
            List<GHRepository> repositories = user.listRepositories().toList();
            return repositories.stream()
                    .filter(repository -> !repository.isFork())
                    .map(this::convertToRepositoryInfo)
                    .collect(Collectors.toList());

        } catch (GHFileNotFoundException e) {
            throw new GHFileNotFoundException("User " + name + " not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private RepositoryName convertToRepositoryInfo(GHRepository repo) {
        try {
            List<BranchInfo> branches = repo.getBranches().values().stream()
                    .map(branch -> BranchInfo.builder()
                            .name(branch.getName())
                            .lastCommitSha(branch.getSHA1())
                            .build())
                    .collect(Collectors.toList());

            return RepositoryName.builder()
                    .name(repo.getName())
                    .ownerLogin(repo.getOwnerName())
                    .branches(branches)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch branches for repository " + repo.getName(), e);
        }


    }

}
