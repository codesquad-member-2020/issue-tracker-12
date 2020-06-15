package dev.codesquad.issuetracker.service;

import static org.junit.jupiter.api.Assertions.*;

import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.repository.LabelRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LabelServiceTest {

    @Autowired
    private LabelService labelService;

    @Autowired
    private LabelRepository labelRepository;

    @Test
    public void 전체_라벨_가져오기() throws Exception {
        //given
        List<Label> labels = labelRepository.findAll();
        int count = labelService.viewAll().getCount();
        //when

        //then
        assertEquals(labels.size(), count);
    }
}