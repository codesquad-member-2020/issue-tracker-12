package dev.codesquad.issuetracker.web.dto.issue;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.web.dto.label.LabelDto;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneDto;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneResponse;
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
    private MilestoneResponse milestone;
    private List<LabelDto> labels = new ArrayList<>();

    @Builder
    protected IssueResponse(Long id, String title, String githubId, LocalDate createTime,
        Status status, int comment, MilestoneResponse milestone, List<LabelDto> labels) {
        this.id = id;
        this.title = title;
        this.githubId = githubId;
        this.createTime = createTime;
        this.status = status;
        this.comment = comment;
        this.milestone = milestone;
        this.labels = labels;
    }

    public static IssueResponse of(Issue issue) {
        return IssueResponse.builder()
            .id(issue.getId())
            .title(issue.getTitle())
            .githubId(issue.getUser().getGithubId())
            .createTime(issue.getCreateTime())
            .status(issue.getStatus())
            .comment(issue.getComments().size())
            .milestone(MilestoneResponse.of(issue.getMilestone()))
            .labels(issue.getLabels().stream()
                .map(label -> LabelDto.of(label))
                .collect(Collectors.toList()))
            .build();
    }
}
