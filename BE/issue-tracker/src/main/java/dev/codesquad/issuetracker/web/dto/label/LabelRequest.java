package dev.codesquad.issuetracker.web.dto.label;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LabelRequest {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String textColor;

    @NotNull
    private String backgroundColor;
}
