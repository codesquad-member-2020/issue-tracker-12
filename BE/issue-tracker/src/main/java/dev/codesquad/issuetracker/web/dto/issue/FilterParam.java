package dev.codesquad.issuetracker.web.dto.issue;

import dev.codesquad.issuetracker.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilterParam {

    private Status status;
    private String author;
    private String label;
    private String milestone;
    private String assignee;
    private String commentAuthor;
}
