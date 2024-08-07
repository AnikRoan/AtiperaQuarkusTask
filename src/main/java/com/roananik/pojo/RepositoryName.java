package com.roananik.pojo;

import lombok.Builder;

import java.util.List;
@Builder
public record RepositoryName(String name, String ownerLogin, List<BranchInfo> branches) {
}
