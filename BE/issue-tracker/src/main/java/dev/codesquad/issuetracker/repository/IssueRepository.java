package dev.codesquad.issuetracker.repository;

import dev.codesquad.issuetracker.domain.Status;
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

    public List<Issue> findAllByStatus(Status status) {
        final int PAGE_SIZE = 30;
        return em.createQuery("select distinct i from Issue i"
            + " left outer join fetch i.user u"
            + " left outer join fetch i.labels l"
            + " left outer join fetch i.milestone m"
            + " where i.status = :status", Issue.class)
            .setParameter("status", status)
            .setMaxResults(PAGE_SIZE)
            .getResultList();
    }
}
