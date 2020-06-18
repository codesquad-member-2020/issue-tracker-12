package dev.codesquad.issuetracker.web.dto.issue;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommentRequest {

    @NotNull
    private Long id;

    @NotNull
    private String content;
}
