package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.domain.vo.Label;
import dev.codesquad.issuetracker.repository.IssueRepository;
import dev.codesquad.issuetracker.repository.LabelRepository;
import dev.codesquad.issuetracker.repository.UserRepository;
import dev.codesquad.issuetracker.web.dto.IssueResponse;
import dev.codesquad.issuetracker.web.dto.ResultResponse;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.UserResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;
    private final UserRepository userRepository;
    private final LabelRepository labelRepository;

    @Transactional(readOnly = true)
    public List<IssueResponse> viewAllIssue() {
        return issueRepository.findAllWithUserLabel().stream()
            .map(issue -> IssueResponse.of(issue))
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ResultResponse viewAll() {
        List<UserResponse> userResponses = userRepository.findAll().stream()
            .map(user -> UserResponse.of(user))
            .collect(Collectors.toList());
        ResultDto user = new ResultDto(userResponses.size(), userResponses);

        List<IssueResponse> issueResponses = issueRepository.findAllWithUserLabel().stream()
            .map(issue -> IssueResponse.of(issue))
            .collect(Collectors.toList());
        ResultDto issue = new ResultDto(issueResponses.size(), issueResponses);

        List<Label> labels = labelRepository.findAll();
        ResultDto label = new ResultDto(labels.size(), labels);

        return ResultResponse.builder()
            .issue(issue)
            .user(user)
            .label(label)
            .build();
    }
}
