package dev.codesquad.issuetracker.web.dto.issue;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Comment;
import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.web.dto.label.LabelDto;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneResponse;
import dev.codesquad.issuetracker.web.dto.user.UserResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
public class IssueDetailResponse {

    private Long id;
    private String title;
    private String content;
    private String githubId;
    private LocalDate createTime;
    private Status status;
    private int comment;
    private List<Comment> comments;
    private List<UserResponse> assignees = new ArrayList<>();
    private MilestoneResponse milestone;
    private List<LabelDto> labels = new ArrayList<>();

    @Builder
    public IssueDetailResponse(Long id, String title, String content, String githubId,
        LocalDate createTime, Status status, int comment, List<Comment> comments,
        List<UserResponse> assignees, MilestoneResponse milestone, List<LabelDto> labels) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.githubId = githubId;
        this.createTime = createTime;
        this.status = status;
        this.comment = comment;
        this.comments = comments;
        this.assignees = assignees;
        this.milestone = milestone;
        this.labels = labels;
    }

    public static IssueDetailResponse of(Issue issue) {
        return IssueDetailResponse.builder()
            .id(issue.getId())
            .title(issue.getTitle())
            .content(issue.getContent())
            .githubId(issue.getUser().getGithubId())
            .createTime(issue.getCreateTime())
            .status(issue.getStatus())
            .comment(issue.getComments().size())
            .comments(issue.getComments())
            .assignees(issue.getUsers().stream()
                .map(user -> UserResponse.of(user))
                .collect(Collectors.toList()))
            .milestone(MilestoneResponse.of(issue.getMilestone()))
            .labels(issue.getLabels().stream()
                .map(label -> LabelDto.of(label))
                .collect(Collectors.toList()))
            .build();
    }
}
