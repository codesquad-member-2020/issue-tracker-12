package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.service.LabelService;
import dev.codesquad.issuetracker.web.dto.label.LabelRequest;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LabelController {

    private final LabelService labelService;

    @GetMapping("/labels")
    public ResponseEntity viewLabels() {
        return new ResponseEntity(labelService.viewAll(), HttpStatus.OK);
    }

    @PostMapping("/labels")
    public ResponseEntity creatLabel(@RequestBody @Valid LabelRequest labelRequest) {
        return new ResponseEntity(labelService.create(labelRequest), HttpStatus.OK);
    }

    @PutMapping("/labels/{id}")
    public ResponseEntity updateLabel(@PathVariable Long id, @RequestBody @Valid LabelRequest labelRequest) {
        return new ResponseEntity(labelService.update(id, labelRequest), HttpStatus.OK);
    }

    @DeleteMapping("/labels/{id}")
    public ResponseEntity removeLabel(@PathVariable Long id) {
        return new ResponseEntity(labelService.remove(id), HttpStatus.OK);
    }
}
