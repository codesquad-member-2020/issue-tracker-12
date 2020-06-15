package dev.codesquad.issuetracker.repository;

import dev.codesquad.issuetracker.domain.label.Label;
import java.util.List;
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
}
