package dev.codesquad.issuetracker.web.dto.issue;

import dev.codesquad.issuetracker.domain.Status;
import lombok.Data;

@Data
public class FilterParam {

    private Status status;
    private String author;
    private String label;
    private String assignee;
}
