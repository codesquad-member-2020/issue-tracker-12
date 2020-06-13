package dev.codesquad.issuetracker.web.dto;

import dev.codesquad.issuetracker.domain.label.Label;
import lombok.Builder;
import lombok.Data;

@Data
public class LabelDto {

    private String name;
    private String code;

    @Builder
    protected LabelDto(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static LabelDto of(Label label) {
        return LabelDto.builder()
            .name(label.getName())
            .code(label.getColorCode())
            .build();
    }
}
