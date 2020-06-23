package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.service.IssueService;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.ResultResponse;
import dev.codesquad.issuetracker.web.dto.issue.CommentRequest;
import dev.codesquad.issuetracker.web.dto.issue.CommentResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueCreateResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueDetailResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueRequest;
import dev.codesquad.issuetracker.web.dto.issue.IssueResponse;
import dev.codesquad.issuetracker.web.dto.issue.StatusRequest;
import dev.codesquad.issuetracker.web.dto.issue.FilterParam;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneDto;
import dev.codesquad.issuetracker.web.dto.user.UserResponse;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    @GetMapping("")
    public ResponseEntity<ResultResponse> viewIssues(
        @RequestParam(value = "status", required = false, defaultValue = "OPEN") Status status) {
        return new ResponseEntity(issueService.viewAll(status), HttpStatus.OK);
    }

    /**
     * assignee & label을 지정하지 않으면 empty array milestone을 지정하지 않으면 -1
     */
    @PostMapping("")
    public ResponseEntity<IssueCreateResponse> createIssue(
        @RequestBody @Valid IssueRequest issueRequest) {
        return new ResponseEntity(issueService.create(issueRequest), HttpStatus.OK);
    }

    @PutMapping("/status")
    public ResponseEntity<IssueResponse> updateStatuses(@RequestBody StatusRequest statusRequest) {
        return new ResponseEntity(
            issueService.updateStatuses(statusRequest.getIds(), statusRequest.getStatus()),
            HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDetailResponse> viewIssueDetail(@PathVariable Long id) {
        return new ResponseEntity(issueService.view(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/title")
    public ResponseEntity<String> updateIssueTitle(@PathVariable Long id,
        @RequestBody String title) {
        return new ResponseEntity(issueService.updateTitle(id, title), HttpStatus.OK);
    }

    @PutMapping("/{id}/content")
    public ResponseEntity<String> updateIssueContent(@PathVariable Long id,
        @RequestBody String content) {
        return new ResponseEntity(issueService.updateContent(id, content), HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id,
        @RequestBody Status status) {
        return new ResponseEntity(issueService.updateStatus(id, status), HttpStatus.OK);
    }

    @PutMapping("/{id}/labels")
    public ResponseEntity<List<Label>> updateLabel(@PathVariable Long id,
        @RequestBody List<Long> labelIds) {
        return new ResponseEntity(issueService.updateLabel(id, labelIds), HttpStatus.OK);
    }

    @PutMapping("/{id}/assignees")
    public ResponseEntity<List<UserResponse>> updateAssignee(@PathVariable Long id,
        @RequestBody List<Long> assigneeIds) {
        return new ResponseEntity(issueService.updateAssignee(id, assigneeIds), HttpStatus.OK);
    }

    @PutMapping("/{id}/milestone")
    public ResponseEntity<MilestoneDto> updateMilestone(@PathVariable Long id,
        @RequestBody Long milestoneId) {
        return new ResponseEntity(issueService.updateMilestone(id, milestoneId), HttpStatus.OK);
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<CommentResponse> addComment(@PathVariable Long id,
        @RequestBody String comment) {
        return new ResponseEntity((issueService.addComment(id, comment)), HttpStatus.OK);
    }

    @PutMapping("/{id}/comment")
    public ResponseEntity<List<CommentResponse>> updateComment(@PathVariable Long id,
        @RequestBody CommentRequest commentRequest) {
        return new ResponseEntity((issueService.updateComment(id, commentRequest)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/comment")
    public ResponseEntity<List<CommentResponse>> removeComment(@PathVariable Long id,
        @RequestBody Long commentId) {
        return new ResponseEntity((issueService.removeComment(id, commentId)), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ResultDto> viewFilteredIssue(FilterParam filterParam) {
        return new ResponseEntity(issueService.viewFiltered(filterParam), HttpStatus.OK);
    }
}
