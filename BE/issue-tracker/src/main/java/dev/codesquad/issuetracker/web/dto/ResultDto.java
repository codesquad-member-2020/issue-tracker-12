package dev.codesquad.issuetracker.web.dto;

import lombok.Data;

@Data
public class ResultDto<T> {

    private int count;
    private T data;

    public ResultDto(int count, T data) {
        this.count = count;
        this.data = data;
    }
}
