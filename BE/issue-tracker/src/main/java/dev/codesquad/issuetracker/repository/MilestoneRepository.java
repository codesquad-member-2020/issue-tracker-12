package dev.codesquad.issuetracker.repository;

import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.label.Label;
import dev.codesquad.issuetracker.domain.milestone.Milestone;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MilestoneRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Milestone> findAll() {
        return em.createQuery("select m from Milestone m", Milestone.class).getResultList();
    }

    public List<Milestone> findAllByStatus(Status status) {
        return em.createQuery("select m from Milestone m"
            + " where m.status = :status", Milestone.class)
            .setParameter("status", status)
            .getResultList();
    }

    public Optional<Milestone> findOne(Long id) {
        return Optional.ofNullable(em.find(Milestone.class, id));
    }

    public void save(Milestone milestone) {
        em.persist(milestone);
    }

    public void remove(Milestone milestone) {
        em.remove(milestone);
    }
}
