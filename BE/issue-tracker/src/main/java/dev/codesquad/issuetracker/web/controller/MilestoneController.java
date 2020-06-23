package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.service.MilestoneService;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneRequest;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;
    
    @GetMapping("")
    public ResponseEntity<ResultDto> viewMilestones() {
        return new ResponseEntity(milestoneService.viewAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createMilestone(@RequestBody @Valid MilestoneRequest milestoneRequest) {
        return new ResponseEntity(milestoneService.create(milestoneRequest), HttpStatus.OK);
    }
}
