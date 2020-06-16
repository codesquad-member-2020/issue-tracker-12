package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.repository.UserRepository;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.user.UserResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public ResultDto viewAll() {
        List<UserResponse> userResponses = getUserResponses();
        return new ResultDto(userResponses.size(), userResponses);
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUserResponses() {
        return userRepository.findAll().stream()
            .map(user -> UserResponse.of(user))
            .collect(Collectors.toList());
    }
}
