package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.service.MilestoneService;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MilestoneController {

    private final MilestoneService milestoneService;
    
    @GetMapping("/milestones")
    public ResponseEntity<ResultDto> viewMilestones() {
        return new ResponseEntity(milestoneService.viewAll(), HttpStatus.OK);
    }
}
