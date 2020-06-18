package dev.codesquad.issuetracker.domain.issue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.codesquad.issuetracker.domain.user.User;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@ToString(exclude = {"user", "issue"})
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String content;

    @CreationTimestamp
    private LocalDate create_time;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    private Issue issue;

    @Builder
    protected Comment(String content, Issue issue, User user) {
        this.content = content;
        this.issue = issue;
        this.user = user;
    }

    public static Comment of(String content, Issue issue, User user) {
        return Comment.builder()
            .content(content)
            .issue(issue)
            .user(user)
            .build();
    }
}
