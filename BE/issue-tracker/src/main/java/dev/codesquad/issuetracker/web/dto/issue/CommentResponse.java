package dev.codesquad.issuetracker.web.dto.issue;

import dev.codesquad.issuetracker.domain.issue.Comment;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
public class CommentResponse {

    private Long id;
    private String content;
    private LocalDate createTime;

    @Builder
    protected CommentResponse(Long id, String content, LocalDate createTime) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
    }

    public static CommentResponse of(Comment comment) {
        return CommentResponse.builder()
            .id(comment.getId())
            .content(comment.getContent())
            .createTime(comment.getCreateTime())
            .build();
    }
}
