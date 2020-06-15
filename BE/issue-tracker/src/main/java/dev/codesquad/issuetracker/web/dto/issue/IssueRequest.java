package dev.codesquad.issuetracker.web.dto.issue;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IssueRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;
}
