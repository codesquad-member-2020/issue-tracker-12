package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping("/")
    public ResponseEntity main() {
        return ResponseEntity.ok(issueService.viewAll());
    }
}
