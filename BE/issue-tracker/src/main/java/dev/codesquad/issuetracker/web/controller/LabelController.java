package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LabelController {

    private final LabelService labelService;

    @GetMapping("/labels")
    public ResponseEntity viewLabels() {
        return new ResponseEntity(labelService.viewAll(), HttpStatus.OK);
    }
}
