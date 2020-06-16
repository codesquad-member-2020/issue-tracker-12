package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.service.IssueService;
import dev.codesquad.issuetracker.web.dto.ResultResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueCreateResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueDetailResponse;
import dev.codesquad.issuetracker.web.dto.issue.IssueRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/issues")
public class IssueController {

    private final IssueService issueService;

    @GetMapping("")
    public ResponseEntity<ResultResponse> viewIssues() {
        return new ResponseEntity(issueService.viewAll(), HttpStatus.OK);
    }

    /**
     * assignee & label을 지정하지 않으면 empty array milestone을 지정하지 않으면 -1
     */
    @PostMapping("")
    public ResponseEntity<IssueCreateResponse> createIssue(
        @RequestBody @Valid IssueRequest issueRequest) {
        return new ResponseEntity(issueService.create(issueRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDetailResponse> viewIssueDetail(@PathVariable Long id) {
        return new ResponseEntity(issueService.view(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}/title")
    public ResponseEntity updateIssueTitle(@PathVariable Long id, @RequestBody String title) {
        return new ResponseEntity(issueService.updateTitle(id, title), HttpStatus.OK);
    }
}
