package dev.codesquad.issuetracker.web.dto.milestone;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.milestone.Milestone;
import dev.codesquad.issuetracker.web.dto.issue.IssueStatusResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
public class MilestoneDto {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;
    private List<IssueStatusResponse> issue;

    @Builder
    protected MilestoneDto(Long id, String title, String description, Status status,
        LocalDate dueDate, List<IssueStatusResponse> issue) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.issue = issue;
    }

    public static MilestoneDto of(Milestone milestone) {
        if (Objects.isNull(milestone)) {
            return null;
        }
        return MilestoneDto.builder()
            .id(milestone.getId())
            .title(milestone.getTitle())
            .description(milestone.getDescription())
            .status(milestone.getStatus())
            .dueDate(milestone.getDueDate())
            .issue(milestone.getIssues().stream()
                .map(issue -> IssueStatusResponse.of(issue))
                .collect(Collectors.toList()))
            .build();
    }
}
