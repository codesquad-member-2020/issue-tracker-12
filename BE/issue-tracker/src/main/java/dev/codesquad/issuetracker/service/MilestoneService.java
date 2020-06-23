package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.common.exception.DataNotFoundException;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.milestone.Milestone;
import dev.codesquad.issuetracker.repository.MilestoneRepository;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneDto;
import dev.codesquad.issuetracker.web.dto.milestone.MilestoneRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;

    @Transactional(readOnly = true)
    public ResultDto viewAll() {
        List<MilestoneDto> milestoneDtos = getMilestoneDto();
        return new ResultDto(milestoneDtos.size(), milestoneDtos);
    }

    @Transactional
    public MilestoneDto create(MilestoneRequest milestoneRequest) {
        Milestone milestone = Milestone
            .of(milestoneRequest.getTitle(), milestoneRequest.getDescription(),
                milestoneRequest.getDueDate());
        milestoneRepository.save(milestone);
        return MilestoneDto.of(milestone);
    }

    @Transactional
    public MilestoneDto remove(Long id) {
        Milestone milestone = findMilestone(id);
        milestone.remove(milestone);
        milestoneRepository.remove(milestone);
        return MilestoneDto.of(milestone);
    }

    @Transactional(readOnly = true)
    public List<MilestoneDto> getMilestoneDto() {
        return milestoneRepository.findAllByStatus(Status.OPEN).stream()
            .map(milestone -> MilestoneDto.of(milestone))
            .collect(Collectors.toList());
    }

    private Milestone findMilestone(Long id) {
        return milestoneRepository.findOne(id).orElseThrow(() -> new DataNotFoundException("Milestone is not exist"));
    }
}
