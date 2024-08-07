package com.roananik.pojo;

import lombok.Builder;

@Builder
public record BranchInfo(String name, String lastCommitSha) {
}
