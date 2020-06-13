package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.service.IssueService;
import dev.codesquad.issuetracker.web.dto.ResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping("/issues")
    public ResponseEntity<ResultResponse> viewIssues() {
        return new ResponseEntity(issueService.viewAll(), HttpStatus.OK);
    }
}
