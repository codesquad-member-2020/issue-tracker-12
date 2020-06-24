package dev.codesquad.issuetracker.web.dto.label;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
