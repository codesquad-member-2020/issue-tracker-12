package dev.codesquad.issuetracker.web.dto.milestone;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MilestoneRequest {

    @NotNull
    private String title;

    private String description;
    private LocalDate dueDate;
}
