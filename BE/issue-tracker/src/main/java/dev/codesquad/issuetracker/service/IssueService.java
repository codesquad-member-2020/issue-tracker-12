package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.common.exception.DataNotFoundException;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.domain.milestone.Milestone;
import dev.codesquad.issuetracker.domain.user.User;
import dev.codesquad.issuetracker.repository.IssueRepository;
import dev.codesquad.issuetracker.repository.LabelRepository;
import dev.codesquad.issuetracker.repository.MilestoneRepository;
import dev.codesquad.issuetracker.repository.UserRepository;
import dev.codesquad.issuetracker.web.dto.issue.IssueRequest;
import dev.codesquad.issuetracker.web.dto.issue.IssueResponse;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneResponse;
import dev.codesquad.issuetracker.web.dto.ResultResponse;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.user.UserResponse;
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

    /**
     *
     * id가 없거나, 지정 안해주거나, null인 경우는..?
     */
    @Transactional
    public IssueResponse create(IssueRequest issueRequest, Long userId, Long labelId, Long milestoneId) {
        User assignee = findUser(userId);
        Label label = findLabel(labelId);
        Milestone milestone = findMilestone(milestoneId);

        // oauth user 정보로 가져오도록 refactoring 한다.
        User user = userRepository.findOne(1L).orElseThrow(null);

        Issue issue = Issue.of(issueRequest.getTitle(), issueRequest.getContent());
        issue.addAssignee(assignee);
        issue.addLabel(label);
        issue.addMilestone(milestone);
        issue.addUser(user);

        issueRepository.save(issue);

        return IssueResponse.of(issue);
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

    private User findUser(Long userId) {
        return userRepository.findOne(userId)
            .orElseThrow(() -> new DataNotFoundException("User is not exist"));
    }

    private Label findLabel(Long labelId) {
        return labelRepository.findOne(labelId)
            .orElseThrow(() -> new DataNotFoundException("Label is not exist"));
    }

    private Milestone findMilestone(Long milestoneId) {
        return milestoneRepository.findOne(milestoneId)
            .orElseThrow(() -> new DataNotFoundException("Milestone is not exist"));
    }
}
