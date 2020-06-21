package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.repository.IssueRepository;
import dev.codesquad.issuetracker.repository.LabelRepository;
import dev.codesquad.issuetracker.repository.MilestoneRepository;
import dev.codesquad.issuetracker.repository.UserRepository;
import dev.codesquad.issuetracker.web.dto.IssueResponse;
import dev.codesquad.issuetracker.web.dto.MilestoneResponse;
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
    private final MilestoneRepository milestoneRepository;

    @Transactional(readOnly = true)
    public List<IssueResponse> viewAllIssue() {
        return issueRepository.findAllByStatus(Status.OPEN).stream()
            .map(issue -> IssueResponse.of(issue))
            .collect(Collectors.toList());
    }

    /**
     * collection 호출 쿼리 최적화 필요
     */
    @Transactional(readOnly = true)
    public ResultResponse viewAll() {
        List<UserResponse> userResponses = getUserResponses();
        ResultDto user = new ResultDto(userResponses.size(), userResponses);
        List<IssueResponse> issueResponses = getIssueResponses();
        ResultDto issue = new ResultDto(issueResponses.size(), issueResponses);
        List<Label> labels = getLabels();
        ResultDto label = new ResultDto(labels.size(), labels);
        List<MilestoneResponse> milestones = getMilestoneResponses();
        ResultDto milestone = new ResultDto(milestones.size(), milestones);

        return ResultResponse.builder()
            .issue(issue)
            .user(user)
            .label(label)
            .milestone(milestone)
            .build();
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUserResponses() {
        return userRepository.findAll().stream()
            .map(user -> UserResponse.of(user))
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<IssueResponse> getIssueResponses() {
        return issueRepository.findAllByStatus(Status.OPEN).stream()
            .map(issue -> IssueResponse.of(issue))
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Label> getLabels() {
        return labelRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<MilestoneResponse> getMilestoneResponses() {
        return milestoneRepository.findAllByStatus(Status.OPEN).stream()
            .map(milestone -> MilestoneResponse.of(milestone))
            .collect(Collectors.toList());
    }
}
