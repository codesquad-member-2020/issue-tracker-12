package dev.codesquad.issuetracker.web.dto.milestone;

import dev.codesquad.issuetracker.domain.milestone.Milestone;
import java.util.Objects;
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
        if (Objects.isNull(milestone)) {
            return null;
        }
        return MilestoneResponse.builder()
            .id(milestone.getId())
            .title(milestone.getTitle())
            .build();
    }
}
