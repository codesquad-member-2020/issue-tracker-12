package dev.codesquad.issuetracker.repository;

import dev.codesquad.issuetracker.common.exception.DataNotFoundException;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public Optional<Issue> findOne(Long id) {
        return em.createQuery("select distinct i from Issue i"
            + " left outer join fetch i.user u"
            + " left outer join fetch i.milestone m"
            + " where i.id = :id", Issue.class)
            .setParameter("id", id)
            .getResultList().stream().findFirst();
    }

    public List<Issue> findAll() {
        return em.createQuery("select i from Issue i", Issue.class).getResultList();
    }

    public List<Issue> findAllByStatus(Status status) {
        final int PAGE_SIZE = 30;
        return em.createQuery("select distinct i from Issue i"
            + " left outer join fetch i.user u"
            + " left outer join fetch i.milestone m"
            + " where i.status = :status", Issue.class)
            .setParameter("status", status)
            .setMaxResults(PAGE_SIZE)
            .getResultList();
    }

    public List<Issue> findList(List<Long> ids) {
        List<Issue> issues = new ArrayList<>();
        if (ids.size() == 0) {
            return issues;
        }
        for (Long id : ids) {
            Issue issue = findOne(id).orElseThrow(() -> new DataNotFoundException("Issue is not exist"));
            issues.add(issue);
        }
        return issues;
    }
}
