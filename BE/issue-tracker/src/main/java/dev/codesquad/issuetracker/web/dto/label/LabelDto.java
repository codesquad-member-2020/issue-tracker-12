package dev.codesquad.issuetracker.web.dto.label;

import dev.codesquad.issuetracker.domain.label.Label;
import lombok.Builder;
import lombok.Data;

@Data
public class LabelDto {

    private String name;
    private String textColor;
    private String backgroundColor;

    @Builder
    protected LabelDto(String name, String textColor, String backgroundColor) {
        this.name = name;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public static LabelDto of(Label label) {
        return LabelDto.builder()
            .name(label.getName())
            .textColor(label.getTextColor())
            .backgroundColor(label.getBackgroundColor())
            .build();
    }
}
