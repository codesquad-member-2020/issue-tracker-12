package dev.codesquad.issuetracker.domain.issue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.domain.milestone.Milestone;
import dev.codesquad.issuetracker.domain.user.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@ToString(exclude = {"users", "user", "milestone"})
@NoArgsConstructor
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDate create_time;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "assignee",
        joinColumns = @JoinColumn(name = "issue_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @ManyToMany
    @JoinTable(name = "issue_has_label",
        joinColumns = @JoinColumn(name = "issue_id"),
        inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Label> labels = new ArrayList<>();

    @Builder
    protected Issue(String title, String content, Status status, LocalDate create_time) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.create_time = create_time;
    }

    public static Issue of(String title, String content) {
        return Issue.builder()
            .title(title)
            .content(content)
            .status(Status.OPEN)
            .build();
    }

    public void addAssignee(User user) {
        users.add(user);
    }

    public void addLabel(Label label) {
        labels.add(label);
    }

    public void addMilestone(Milestone milestone) {
        if (Objects.isNull(milestone)) {
            return;
        }
        this.milestone = milestone;
    }

    public void addUser(User user) {
        this.user = user;
    }

    public void addLabels(List<Label> labels) {
        for (Label label : labels) {
            addLabel(label);
        }
    }

    public void addAssignees(List<User> assignees) {
        for (User assignee : assignees) {
            users.add(assignee);
        }
    }

    public void update(User user, List<User> assignees, List<Label> labels, Milestone milestone) {
        addUser(user);
        addAssignees(assignees);
        addLabels(labels);
        addMilestone(milestone);
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    public void updateLabel(List<Label> labels) {
        this.labels.clear();
        this.labels = labels;
    }
}
