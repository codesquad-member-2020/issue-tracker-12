package dev.codesquad.issuetracker.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.domain.issue.QIssue;
import dev.codesquad.issuetracker.domain.milestone.QMilestone;
import dev.codesquad.issuetracker.domain.user.QUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class IssueQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Issue> findFilteredIssue(Status status, String author) {
        QIssue issue = QIssue.issue;
        QUser user = QUser.user;
        QMilestone milestone = QMilestone.milestone;
        JPAQueryFactory query = new JPAQueryFactory(em);

        return query
            .select(issue)
            .from(issue)
            .join(issue.user, user)
            .join(issue.milestone, milestone)
            .where(statusEq(status), authorEq(author))
            .limit(100)
            .fetch();
    }

    private BooleanExpression statusEq(Status status) {
        if (status == null) {
            return null;
        }
        return QIssue.issue.status.eq(status);
    }

    private BooleanExpression authorEq(String author) {
        if (StringUtils.isEmpty(author)) {
            return null;
        }
        return QUser.user.githubId.like(author);
    }
}
