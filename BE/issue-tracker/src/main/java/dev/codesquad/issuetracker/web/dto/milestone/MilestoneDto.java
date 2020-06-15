package dev.codesquad.issuetracker.web.dto.milestone;

import dev.codesquad.issuetracker.domain.milestone.Milestone;
import lombok.Builder;
import lombok.Data;

@Data
public class MilestoneDto {

    private Long id;
    private String title;

    @Builder
    protected MilestoneDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static MilestoneDto of(Milestone milestone) {
        return MilestoneDto.builder()
            .id(milestone.getId())
            .title(milestone.getTitle())
            .build();
    }
}
