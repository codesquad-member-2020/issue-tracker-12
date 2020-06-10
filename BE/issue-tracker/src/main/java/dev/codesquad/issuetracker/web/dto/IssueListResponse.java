package dev.codesquad.issuetracker.web.dto;

import dev.codesquad.issuetracker.domain.issue.Issue;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
public class IssueListResponse {

    private Long issueId;
    private String title;
    private String githubId;
    private LocalDate createTime;
    private List<LabelDto> labels;

    @Builder
    public IssueListResponse(Long issueId, String title, String githubId,
        LocalDate createTime, List<LabelDto> labels) {
        this.issueId = issueId;
        this.title = title;
        this.githubId = githubId;
        this.createTime = createTime;
        this.labels = labels;
    }

    public static IssueListResponse of(Issue issue) {
        return IssueListResponse.builder()
            .issueId(issue.getId())
            .title(issue.getTitle())
            .githubId(issue.getUser().getGithubId())
            .createTime(issue.getCreate_time())
            .labels(issue.getLabels().stream()
                .map(label -> LabelDto.of(label.getName(), label.getColorCode()))
                .collect(Collectors.toList()))
            .build();
    }
}
