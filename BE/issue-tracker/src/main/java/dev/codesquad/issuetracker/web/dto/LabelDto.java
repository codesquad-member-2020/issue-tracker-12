package dev.codesquad.issuetracker.web.dto;

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

    public static LabelDto of(String name, String code) {
        return LabelDto.builder()
            .name(name)
            .code(code)
            .build();
    }
}
