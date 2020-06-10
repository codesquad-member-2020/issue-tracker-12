package dev.codesquad.issuetracker.domain.vo;

import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@NoArgsConstructor
public class Label {

    private String name;
    private String description;
    private String colorCode;
}
