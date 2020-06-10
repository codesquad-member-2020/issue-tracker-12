package dev.codesquad.issuetracker.web.dto;

import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.domain.vo.Label;
import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class IssueListResponse {

    private Long issueId;
    private String title;
    private List<Label> labels;
    private LocalDate createTime;
    private String githubId;

    @Builder
    protected IssueListResponse(Long issueId, String title,
        List<Label> labels, LocalDate createTime, String githubId) {
        this.issueId = issueId;
        this.title = title;
        this.labels = labels;
        this.createTime = createTime;
        this.githubId = githubId;
    }

    public static IssueListResponse of(Issue issue) {
        return IssueListResponse.builder()
            .issueId(issue.getId())
            .title(issue.getTitle())
            .labels(issue.getLabels())
            .createTime(issue.getCreate_time())
            .githubId(issue.getUser().getGithubId())
            .build();
    }
}
