package dev.codesquad.issuetracker.repository;

import dev.codesquad.issuetracker.domain.milestone.Milestone;
import java.util.List;
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
}
