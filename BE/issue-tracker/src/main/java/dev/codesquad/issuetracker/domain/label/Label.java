package dev.codesquad.issuetracker.domain.label;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.codesquad.issuetracker.domain.issue.Issue;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString(exclude = "issues")
@NoArgsConstructor
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String textColor;

    @NotNull
    private String backgroundColor;

    @JsonIgnore
    @ManyToMany(mappedBy = "labels")
    private List<Issue> issues = new ArrayList<>();

    @Builder
    protected Label(String name, String description, String textColor, String backgroundColor) {
        this.name = name;
        this.description = description;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public static Label of(String name, String description, String textColor, String backgroundColor) {
        return Label.builder()
            .name(name)
            .description(description)
            .textColor(textColor)
            .backgroundColor(backgroundColor)
            .build();
    }

    public Label update(String name, String description, String textColor, String backgroundColor) {
        this.name = name;
        this.description = description;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        return this;
    }
}
