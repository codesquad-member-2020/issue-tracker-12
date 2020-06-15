package dev.codesquad.issuetracker.web.dto.milestone;

import dev.codesquad.issuetracker.domain.milestone.Milestone;
import lombok.Builder;
import lombok.Data;

@Data
public class MilestoneResponse {

    private Long id;
    private String title;

    @Builder
    protected MilestoneResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static MilestoneResponse of(Milestone milestone) {
        return MilestoneResponse.builder()
            .id(milestone.getId())
            .title(milestone.getTitle())
            .build();
    }
}
