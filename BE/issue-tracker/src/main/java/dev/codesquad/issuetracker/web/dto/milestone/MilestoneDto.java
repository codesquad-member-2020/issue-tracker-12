package dev.codesquad.issuetracker.web.dto.milestone;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.milestone.Milestone;
import java.time.LocalDate;
import java.util.Objects;
import lombok.Builder;
import lombok.Data;

@Data
public class MilestoneDto {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;

    @Builder
    protected MilestoneDto(Long id, String title, String description, Status status, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
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
            .build();
    }
}
