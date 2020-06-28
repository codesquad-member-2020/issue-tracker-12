package dev.codesquad.issuetracker.service;

/**
 * 매뉴얼로 추가했음 -> Class Path 추가하기
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.repository.IssueRepository;
import dev.codesquad.issuetracker.repository.LabelRepository;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.issue.FilterParam;
import dev.codesquad.issuetracker.web.dto.issue.IssueCreateResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueDetailResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueRequest;
import dev.codesquad.issuetracker.web.dto.user.UserResponse;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class IssueServiceTest {

    @Autowired
    private IssueService issueService;

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("이슈 생성 API")
    @Transactional
    public void test_create() throws Exception {
        //given
        List<Long> userIds = Arrays.asList(1L, 2L);
        List<Long> labelIds = Arrays.asList(1L, 2L, 3L);
        Long milestoneId = 1L;
        IssueRequest request = new IssueRequest("test_title", "test_content", userIds, labelIds, milestoneId);

        int totalIssueNumber = issueRepository.findAll().size();
        Long lastIssueId = Long.valueOf(totalIssueNumber);

        //when
        IssueCreateResponse issueCreateResponse = issueService.create(request);
        Issue issue = issueRepository.findOne(lastIssueId + 1).orElse(null);

        //then
        assertThat(issueRepository.findAll().size()).isEqualTo(totalIssueNumber + 1);
        assertThat(issueCreateResponse.getTitle()).isEqualTo(issue.getTitle());
        assertThat(issueCreateResponse.getId()).isEqualTo(issue.getId());
    }

    @Test
    @DisplayName("이슈 상세 조회")
    @Transactional
    public void test_viewDetail() throws Exception {
        //given
        int totalIssueNumber = issueRepository.findAll().size();
        Long lastIssueId = Long.valueOf(totalIssueNumber);

        //when
        IssueDetailResponse issueDetailResponse = issueService.view(lastIssueId);
        Issue issue = issueRepository.findOne(lastIssueId).orElse(null);
        IssueDetailResponse issueResponse = IssueDetailResponse.of(issue);

        //then
        assertThat(issueDetailResponse.getId()).isEqualTo(issue.getId());
        assertThat(issueDetailResponse).isEqualTo(issueResponse);
    }

    @Test
    @DisplayName("이슈 레이블 변경")
    @Transactional
    public void test_updateLabel() throws Exception {
        //given
        int totalIssueNumber = issueRepository.findAll().size();
        Long lastIssueId = Long.valueOf(totalIssueNumber);
        List<Long> labelIds = Arrays.asList(1L, 2L, 3L);
        List<Label> label = labelRepository.findList(labelIds);
        Issue issue = issueRepository.findOne(6L).orElse(null);

        //when
        issueService.updateLabel(lastIssueId, labelIds);

        //then
        assertThat(label).isEqualTo(issue.getLabels());
    }

    @Test
    @DisplayName("이슈 목록 상태 변경")
    @Transactional
    public void updateStatuses() throws Exception {
        //given
        int totalIssueNumber = issueRepository.findAll().size();
        List<Long> ids = Arrays.asList(1L, 3L, 5L);

        //when
        issueService.updateStatuses(ids, Status.CLOSE);

        //then
        assertAll(
            () -> assertThat(issueRepository.findOne(1L).orElse(null).getStatus()).isEqualTo(Status.CLOSE),
            () -> assertThat(issueRepository.findOne(3L).orElse(null).getStatus()).isEqualTo(Status.CLOSE),
            () -> assertThat(issueRepository.findOne(5L).orElse(null).getStatus()).isNotEqualTo(Status.OPEN));
    }

    /**
     *
     * coverage 늘릴 방법 생각하기
     */
    @Test
    @DisplayName("이슈 필터링 조회")
    @Transactional
    public void test_viewFiltered() throws Exception {
        //given
        Status status = Status.OPEN;
        String author = "wooody92";
        String label = null;
        String milestone = null;
        String assignee = null;
        String commentAuthor = null;
        FilterParam filterParam = new FilterParam(status, author, label, milestone, assignee, commentAuthor);

        int totalIssueNumber = issueRepository.findAll().size();
        Long lastIssueId = Long.valueOf(totalIssueNumber);
        Issue issue = issueRepository.findOne(lastIssueId).orElse(null);
        List<Long> assigneeId = Arrays.asList(2L);

        //when
        List<UserResponse> userResponse = issueService.updateAssignee(lastIssueId, assigneeId);
        ResultDto result = issueService.viewFiltered(filterParam);

        //then
        assertThat(result.getCount()).isEqualTo(3);
        assertThat(result).isInstanceOf(ResultDto.class);
    }
}