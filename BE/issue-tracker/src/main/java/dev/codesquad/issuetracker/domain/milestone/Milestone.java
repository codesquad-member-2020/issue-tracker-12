package dev.codesquad.issuetracker.domain.milestone;

import dev.codesquad.issuetracker.domain.issue.Issue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @ColumnDefault("true")
    private boolean status;

    @NotNull
    @CreationTimestamp
    private LocalDate dueDate;

    @OneToMany(mappedBy = "milestone")
    private List<Issue> issues = new ArrayList<>();
}
