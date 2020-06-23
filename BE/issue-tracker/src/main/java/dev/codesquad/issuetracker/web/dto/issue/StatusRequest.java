package dev.codesquad.issuetracker.web.dto.issue;

import dev.codesquad.issuetracker.domain.Status;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatusRequest {

    @NotNull
    private List<Long> ids = new ArrayList<>();

    @NotNull
    private Status status;
}
