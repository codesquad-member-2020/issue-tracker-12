package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.repository.LabelRepository;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LabelService {

    private final LabelRepository labelRepository;

    @Transactional(readOnly = true)
    public ResultDto viewAll() {
        List<Label> labels = labelRepository.findAll();
        return new ResultDto(labels.size(), labels);
    }
}
