package dev.codesquad.issuetracker.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ResultResponse {

    private ResultDtoResponse issue;
    private ResultDto user;
    private ResultDto label;
    private ResultDto milestone;

    @Builder
    protected ResultResponse(ResultDtoResponse issue, ResultDto user, ResultDto label,
        ResultDto milestone) {
        this.issue = issue;
        this.user = user;
        this.label = label;
        this.milestone = milestone;
    }

    public static ResultResponse of(ResultDtoResponse issue, ResultDto user, ResultDto label,
        ResultDto milestone) {
        return ResultResponse.builder()
            .issue(issue)
            .user(user)
            .label(label)
            .milestone(milestone)
            .build();
    }
}
