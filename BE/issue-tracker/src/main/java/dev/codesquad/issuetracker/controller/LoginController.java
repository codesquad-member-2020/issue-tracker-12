package dev.codesquad.issuetracker.controller;

import dev.codesquad.issuetracker.common.jwt.JwtService;
import dev.codesquad.issuetracker.common.oauth.Github;
import dev.codesquad.issuetracker.common.oauth.GithubUser;
import dev.codesquad.issuetracker.common.oauth.LoginService;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;
    private final JwtService jwtService;
//  private final UserService userService;

    private final String USER_ID = "userId";
    private final String PROFILE_URL = "profileUrl";
    private final Integer EXPIRE_TIME = 60 * 60 * 6;
    private final String HEADER_LOCATION = "Location";
    private final String WEB_REDIRECT_URL = "http://localhost:8080";
    public static final String OAUTH_URL_SERVER = "https://github.com/login/oauth/authorize?client_id=dc2d0592b76e9fb16677&scope=user:email";

    @GetMapping("/callback")
    public ResponseEntity<HttpStatus> oauthCallback(@Param("code") String code,
        HttpServletResponse response) {
        Github github = loginService.requestAccessToken(code);
        GithubUser githubUser = loginService.requestUserInfo(github.getAccessToken());
        log.info("Github Info : {}", githubUser);

//    userService.save(githubUser.getUserId());
        String jwt = jwtService.createToken(githubUser.getUserId());

        Cookie githubId = new Cookie(USER_ID, githubUser.getUserId());
        Cookie githubImage = new Cookie(PROFILE_URL, githubUser.getProfileUrl());
        githubId.setMaxAge(EXPIRE_TIME);
        githubImage.setMaxAge(EXPIRE_TIME);

        response.addCookie(githubId);
        response.addCookie(githubImage);
        response.setHeader(HEADER_LOCATION, WEB_REDIRECT_URL);
        return new ResponseEntity(HttpStatus.FOUND);
    }

    @GetMapping("/")
    public ResponseEntity main() {
        return ResponseEntity.ok("");
    }
}
