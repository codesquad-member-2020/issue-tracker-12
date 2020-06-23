package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.service.MilestoneService;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.ResultDtoResponse;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneDto;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneRequest;
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
@RequestMapping("/milestones")
public class MilestoneController {

    private final MilestoneService milestoneService;

    @GetMapping("")
    public ResponseEntity<ResultDtoResponse> viewMilestones(
        @RequestParam(value = "status", required = false, defaultValue = "OPEN") Status status) {
        return new ResponseEntity(milestoneService.viewAll(status), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<MilestoneDto> createMilestone(
        @RequestBody @Valid MilestoneRequest milestoneRequest) {
        return new ResponseEntity(milestoneService.create(milestoneRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MilestoneDto> removeMilestone(@PathVariable Long id) {
        return new ResponseEntity(milestoneService.remove(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MilestoneDto> updateMilestone(@PathVariable Long id,
        @RequestBody @Valid MilestoneRequest milestoneRequest) {
        return new ResponseEntity(milestoneService.update(id, milestoneRequest), HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status) {
        return new ResponseEntity(milestoneService.updateStatus(id, status), HttpStatus.OK);
    }
}
