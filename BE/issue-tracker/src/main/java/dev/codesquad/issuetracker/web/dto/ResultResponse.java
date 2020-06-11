package dev.codesquad.issuetracker.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ResultResponse {

    private ResultDto issue;
    private ResultDto user;
    private ResultDto label;

    @Builder
    protected ResultResponse(ResultDto issue, ResultDto user, ResultDto label) {
        this.issue = issue;
        this.user = user;
        this.label = label;
    }

    public static ResultResponse of(ResultDto issue, ResultDto user, ResultDto label) {
        return ResultResponse.builder()
            .issue(issue)
            .user(user)
            .label(label)
            .build();
    }
}
