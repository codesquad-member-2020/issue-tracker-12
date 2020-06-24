package dev.codesquad.issuetracker.web.dto.issue;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import lombok.Builder;
import lombok.Data;

@Data
public class IssueStatusResponse {

    private Long id;
    private String title;
    private Status status;

    @Builder
    protected IssueStatusResponse(Long id, String title, Status status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public static IssueStatusResponse of(Issue issue) {
        return IssueStatusResponse.builder()
            .id(issue.getId())
            .title(issue.getTitle())
            .status(issue.getStatus())
            .build();
    }
}
