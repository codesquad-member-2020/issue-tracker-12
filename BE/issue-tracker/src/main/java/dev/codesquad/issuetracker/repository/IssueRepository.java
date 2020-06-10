package dev.codesquad.issuetracker.repository;

import dev.codesquad.issuetracker.domain.issue.Issue;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class IssueRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Issue issue) {
        em.persist(issue);
    }

    public Issue findOne(Long id) {
        return em.find(Issue.class, id);
    }

    public List<Issue> findAll() {
        return em.createQuery("select i from Issue i", Issue.class).getResultList();
    }

    public List<Issue> findAllWithUserLabel() {
        return em.createQuery("select i from Issue i"
            + " left join fetch i.user u"
            + " left join fetch i.labels l", Issue.class)
            .getResultList();
    }
}
