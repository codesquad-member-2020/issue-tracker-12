package dev.codesquad.issuetracker.web.dto.issue;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
public class IssueCreateResponse {

    private Long id;
    private String title;
    private String content;
    private Status status;
    private LocalDate createTime;

    @Builder
    public IssueCreateResponse(Long id, String title, String content,
        Status status, LocalDate createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.createTime = createTime;
    }

    public static IssueCreateResponse of(Issue issue) {
        return IssueCreateResponse.builder()
            .id(issue.getId())
            .title(issue.getTitle())
            .content(issue.getContent())
            .status(issue.getStatus())
            .createTime(issue.getCreate_time())
            .build();
    }
}
