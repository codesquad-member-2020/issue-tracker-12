package dev.codesquad.issuetracker.web.dto;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LabelRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String colorCode;

    public LabelRequestDto(String name, String description, String colorCode) {
        this.name = name;
        this.description = description;
        this.colorCode = colorCode;
    }
}
