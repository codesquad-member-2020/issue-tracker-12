package dev.codesquad.issuetracker.web.controller;

import dev.codesquad.issuetracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity viewUsers() {
        return new ResponseEntity(userService.viewAll(), HttpStatus.OK);
    }
}
