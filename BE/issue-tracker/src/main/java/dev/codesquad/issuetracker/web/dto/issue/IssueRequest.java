package dev.codesquad.issuetracker.web.dto.issue;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private List<Long> userId = new ArrayList<>();

    @NotNull
    private List<Long> labelId = new ArrayList<>();

    @NotNull
    private Long milestoneId;
}
