package dev.codesquad.issuetracker.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ResultResponse {

    private ResultDto issue;
    private ResultDto user;

    @Builder
    protected ResultResponse(ResultDto issue, ResultDto user) {
        this.issue = issue;
        this.user = user;
    }

    public static ResultResponse of(ResultDto issue, ResultDto user) {
        return ResultResponse.builder()
            .issue(issue)
            .user(user)
            .build();
    }
}
