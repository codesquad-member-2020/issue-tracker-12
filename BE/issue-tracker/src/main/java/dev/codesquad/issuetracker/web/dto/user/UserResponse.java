package dev.codesquad.issuetracker.web.dto.user;

import dev.codesquad.issuetracker.domain.user.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String githubId;
    private String profileUrl;

    @Builder
    protected UserResponse(Long id, String githubId, String profileUrl) {
        this.id = id;
        this.githubId = githubId;
        this.profileUrl = profileUrl;
    }

    public static UserResponse of(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .githubId(user.getGithubId())
            .profileUrl(user.getProfileUrl())
            .build();
    }
}
