package dev.codesquad.issuetracker.repository;

import dev.codesquad.issuetracker.common.exception.DataNotFoundException;
import dev.codesquad.issuetracker.domain.label.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class LabelRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Label> findAll() {
        return em.createQuery("select l from Label l", Label.class).getResultList();
    }

    public void save(Label label) {
        em.persist(label);
    }

    public Optional<Label> findOne(Long id) {
        return Optional.ofNullable(em.find(Label.class, id));
    }

    public void remove(Label label) {
        em.remove(label);
    }

    public List<Label> findList(List<Long> ids) {
        List<Label> labels = new ArrayList<>();
        if (ids.size() == 0) {
            return labels;
        }
        for (Long id : ids) {
            Label label = findOne(id).orElseThrow(() -> new DataNotFoundException("Label is not exist"));
            labels.add(label);
        }
        return labels;
    }
}
