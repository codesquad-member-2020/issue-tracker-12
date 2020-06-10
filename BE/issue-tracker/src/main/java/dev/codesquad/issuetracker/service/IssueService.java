package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.repository.IssueRepository;
import dev.codesquad.issuetracker.web.dto.IssueListResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    @Transactional(readOnly = true)
    public List<IssueListResponse> viewAll() {
        return issueRepository.findAll().stream()
            .map(issue -> IssueListResponse.of(issue))
            .collect(Collectors.toList());
    }
}
