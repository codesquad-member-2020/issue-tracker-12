package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.common.exception.DataNotFoundException;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Comment;
import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.domain.milestone.Milestone;
import dev.codesquad.issuetracker.domain.user.User;
import dev.codesquad.issuetracker.repository.IssueQueryRepository;
import dev.codesquad.issuetracker.repository.IssueRepository;
import dev.codesquad.issuetracker.repository.LabelRepository;
import dev.codesquad.issuetracker.repository.MilestoneRepository;
import dev.codesquad.issuetracker.repository.UserRepository;
import dev.codesquad.issuetracker.web.dto.issue.CommentRequest;
import dev.codesquad.issuetracker.web.dto.issue.CommentResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueCreateResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueDetailResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueRequest;
import dev.codesquad.issuetracker.web.dto.issue.IssueResponse;
import dev.codesquad.issuetracker.web.dto.label.LabelDto;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneDto;
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

    private final IssueQueryRepository issueQueryRepository;

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
        List<MilestoneDto> milestones = getMilestoneResponses();
        ResultDto milestone = new ResultDto(milestones.size(), milestones);

        return ResultResponse.builder()
            .issue(issue)
            .user(user)
            .label(label)
            .milestone(milestone)
            .build();
    }

    /**
     * user는 oauth 적용 후 token 정보에서 가져오도록 한다.
     */
    @Transactional
    public IssueCreateResponse create(IssueRequest issueRequest) {
        List<User> assignees = userRepository.findList(issueRequest.getUserId());
        List<Label> labels = labelRepository.findList(issueRequest.getLabelId());
        Milestone milestone = findMilestone(issueRequest.getMilestoneId());

        // oauth user 정보로 가져오도록 refactoring 한다.
        User user = userRepository.findOne(1L).orElseThrow(null);

        Issue issue = Issue.of(issueRequest.getTitle(), issueRequest.getContent());
        issue.update(user, assignees, labels, milestone);
        issueRepository.save(issue);
        return IssueCreateResponse.of(issue);
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
    public List<MilestoneDto> getMilestoneResponses() {
        return milestoneRepository.findAllByStatus(Status.OPEN).stream()
            .map(milestone -> MilestoneDto.of(milestone))
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public IssueDetailResponse view(Long issueId) {
        Issue issue = findIssue(issueId);
        return IssueDetailResponse.of(issue);
    }

    @Transactional
    public String updateTitle(Long issueId, String title) {
        Issue issue = findIssue(issueId);
        issue.updateTitle(title);
        return issue.getTitle();
    }

    @Transactional
    public String updateContent(Long issueId, String content) {
        Issue issue = findIssue(issueId);
        issue.updateContent(content);
        return issue.getContent();
    }

    @Transactional
    public Status updateStatus(Long issueId, Status status) {
        Issue issue = findIssue(issueId);
        issue.updateStatus(status);
        return issue.getStatus();
    }

    @Transactional
    public List<LabelDto> updateLabel(Long issueId, List<Long> labelIds) {
        Issue issue = findIssue(issueId);
        List<Label> labels = labelRepository.findList(labelIds);
        issue.updateLabel(labels);
        return issue.getLabels().stream()
            .map(label -> LabelDto.of(label))
            .collect(Collectors.toList());
    }

    @Transactional
    public List<UserResponse> updateAssignee(Long issueId, List<Long> assigneeIds) {
        Issue issue = findIssue(issueId);
        List<User> users = userRepository.findList(assigneeIds);
        issue.updateAssignee(users);
        return issue.getUsers().stream()
            .map(user -> UserResponse.of(user))
            .collect(Collectors.toList());
    }

    /**
     *
     * if milestone null -> response dto 에서 분기 처리
     */
    @Transactional
    public MilestoneDto updateMilestone(Long issueId, Long milestoneId) {
        Issue issue = findIssue(issueId);
        Milestone milestone = findMilestone(milestoneId);
        issue.updateMilestone(milestone);
        return MilestoneDto.of(issue.getMilestone());
    }

    /**
     * user는 oauth 적용 후 token 정보에서 가져오도록 한다.
     */
    @Transactional
    public CommentResponse addComment(Long issueId, String commentContent) {
        Issue issue = findIssue(issueId);

        // oauth user 정보로 가져오도록 refactoring 한다.
        User user = userRepository.findOne(1L).orElseThrow(null);

        Comment comment = Comment.of(commentContent, issue, user);
        issue.addComment(comment);
        issueRepository.save(issue);
        return CommentResponse.of(comment);
    }

    @Transactional
    public List<CommentResponse> updateComment(Long issueId, CommentRequest commentRequest) {
        Issue issue = findIssue(issueId);
        issue.updateComment(commentRequest.getId(), commentRequest.getContent());
        return issue.getComments().stream()
            .map(comment -> CommentResponse.of(comment))
            .collect(Collectors.toList());
    }

    @Transactional
    public List<CommentResponse> removeComment(Long issueId, Long commentId) {
        Issue issue = findIssue(issueId);
        issue.removeComment(commentId);
        return issue.getComments().stream()
            .map(comment -> CommentResponse.of(comment))
            .collect(Collectors.toList());
    }

    @Transactional
    public List<IssueResponse> updateStatuses(List<Long> ids, Status status) {
        List<Issue> issues = issueRepository.findList(ids);
        issues.stream().forEach(issue -> issue.updateStatus(status));
        return issues.stream()
            .map(issue -> IssueResponse.of(issue))
            .collect(Collectors.toList());
    }

    /**
     * query 최적화 필요
     */
    private Issue findIssue(Long issueId) {
        return issueRepository.findOne(issueId)
            .orElseThrow(() -> new DataNotFoundException("Issue is not exist"));
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
        if (milestoneId == -1) {
            return null;
        }
        return milestoneRepository.findOne(milestoneId)
            .orElseThrow(() -> new DataNotFoundException("Milestone is not exist"));
    }

    @Transactional(readOnly = true)
    public List<Issue> viewFiltered(Status status, String author, String labelName, String milestoneTitle) {
        return issueQueryRepository.findFilteredIssue(status, author, labelName, milestoneTitle);
    }
}
