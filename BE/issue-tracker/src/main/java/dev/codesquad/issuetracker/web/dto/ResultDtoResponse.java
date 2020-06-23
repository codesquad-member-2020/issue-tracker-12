package dev.codesquad.issuetracker.web.dto;

import lombok.Data;

@Data
public class ResultDtoResponse<T> {

    private int open;
    private int close;
    private int count;
    private T data;

    public ResultDtoResponse(int open, int close, int count, T data) {
        this.open = open;
        this.close = close;
        this.count = count;
        this.data = data;
    }
}

