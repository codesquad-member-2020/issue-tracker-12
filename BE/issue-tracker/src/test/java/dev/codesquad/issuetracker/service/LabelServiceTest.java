package dev.codesquad.issuetracker.service;

import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.repository.LabelRepository;
import dev.codesquad.issuetracker.web.dto.ResultDto;
import dev.codesquad.issuetracker.web.dto.label.LabelRequest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LabelServiceTest {

    @Autowired
    private LabelService labelService;

    @Autowired
    private LabelRepository labelRepository;

    @Test
    @Transactional
    public void 전체_라벨_가져오기() throws Exception {
        //given

        //when
        Label savedLabel = labelRepository.findOne(1L).orElse(null);
        List<Label> labels = labelRepository.findAll();

        //then
        assertThat(labels.size()).isEqualTo(5);
        assertThat(labels.get(0)).isInstanceOf(Label.class);
        assertThat(labels.get(0).getName()).isEqualTo(savedLabel.getName());
    }

    @Test
    @DisplayName("레이블 목록 API")
    @Transactional
    public void test_viewAll() throws Exception {
        //given

        //when
        List<Label> labels = labelRepository.findAll();
        ResultDto labelResult = labelService.viewAll();

        //then
        assertThat(labelResult.getCount()).isEqualTo(labels.size());
        assertThat(labelResult.getData()).isEqualTo(labels);
    }

    @Test
    @DisplayName("레이블 생성 API")
    @Transactional
    public void test_create() throws Exception {
        //given
        LabelRequest request = new LabelRequest("test_name", "test_description", "test_textColor",
            "test_BGColor");
        int savedLabelCount = labelRepository.findAll().size();
        Long nextLabelId = Long.valueOf(savedLabelCount + 1);

        //when
        Label label = labelService.create(request);
        Label savedLabel = labelRepository.findOne(nextLabelId).orElse(null);

        //then
        assertThat(label.getName()).isEqualTo("test_name");
        assertThat(label).isEqualTo(savedLabel);
    }

    @Test
    @DisplayName("레이블 삭제 API")
    @Transactional
    public void test_remove() throws Exception {
        //given
        int savedLabelCount = labelRepository.findAll().size();
        Long lastLabelId = Long.valueOf(savedLabelCount);

        //when
        Label label = labelService.remove(lastLabelId);

        //then
        assertThat(labelRepository.findAll().size()).isEqualTo(savedLabelCount - 1);
        assertThat(labelRepository.findOne(lastLabelId)).isEmpty();
    }

    @Test
    @DisplayName("레이블 수정 API")
    @Transactional
    public void test_update() throws Exception {
        //given
        LabelRequest request = new LabelRequest("test_name", "test_description", "test_textColor",
            "test_BGColor");
        int savedLabelCount = labelRepository.findAll().size();
        Long LastLabelId = Long.valueOf(savedLabelCount);

        //when
        Label label = labelService.update(LastLabelId, request);
        Label updatedLabel = labelRepository.findOne(LastLabelId).orElse(null);

        //then
        assertThat(label).isEqualTo(updatedLabel);
    }
}