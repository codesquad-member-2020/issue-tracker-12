package dev.codesquad.issuetracker.web.dto;

import dev.codesquad.issuetracker.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserResponse {

    private String githubId;
    private String profileUrl;

    @Builder
    protected UserResponse(String githubId, String profileUrl) {
        this.githubId = githubId;
        this.profileUrl = profileUrl;
    }

    public static UserResponse of(User user) {
        return UserResponse.builder()
            .githubId(user.getGithubId())
            .profileUrl(user.getProfileUrl())
            .build();
    }
}
