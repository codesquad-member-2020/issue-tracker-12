package dev.codesquad.issuetracker.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
public class IssueResponse {

    private Long id;
    private String title;
    private String githubId;
    private LocalDate createTime;
    private Status status;
    private int comment;
    private List<LabelDto> labels = new ArrayList<>();

    @Builder
    protected IssueResponse(Long id, String title, String githubId,
        LocalDate createTime, Status status, int comment, List<LabelDto> labels) {
        this.id = id;
        this.title = title;
        this.githubId = githubId;
        this.createTime = createTime;
        this.status = status;
        this.comment = comment;
        this.labels = labels;
    }

    public static IssueResponse of(Issue issue) {
        return IssueResponse.builder()
            .id(issue.getId())
            .title(issue.getTitle())
            .githubId(issue.getUser().getGithubId())
            .createTime(issue.getCreate_time())
            .status(issue.getStatus())
            .comment(issue.getComments().size())
            .labels(issue.getLabels().stream()
                .map(label -> LabelDto.of(label.getName(), label.getColorCode()))
                .collect(Collectors.toList()))
            .build();
    }
}
