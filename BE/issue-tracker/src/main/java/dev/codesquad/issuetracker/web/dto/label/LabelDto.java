package dev.codesquad.issuetracker.web.dto.label;

import dev.codesquad.issuetracker.domain.label.Label;
import lombok.Builder;
import lombok.Data;

@Data
public class LabelDto {

    private Long id;
    private String name;
    private String textColor;
    private String backgroundColor;

    @Builder
    protected LabelDto(Long id, String name, String textColor, String backgroundColor) {
        this.id = id;
        this.name = name;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public static LabelDto of(Label label) {
        return LabelDto.builder()
            .id(label.getId())
            .name(label.getName())
            .textColor(label.getTextColor())
            .backgroundColor(label.getBackgroundColor())
            .build();
    }
}
