package dev.codesquad.issuetracker.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.domain.issue.QIssue;
import dev.codesquad.issuetracker.domain.label.QLabel;
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

    public List<Issue> findFilteredIssue(Status status, String author, String labelName, String milestoneTitle) {
        QIssue issue = QIssue.issue;
        QUser user = QUser.user;
        QLabel label = QLabel.label;
        QMilestone milestone = QMilestone.milestone;
        JPAQueryFactory query = new JPAQueryFactory(em);

        return query
            .select(issue)
            .distinct()
            .from(issue)
            .leftJoin(issue.user, user)
            .leftJoin(issue.labels, label)
            .leftJoin(issue.milestone, milestone)
            .where(statusEq(status), authorEq(author), labelEq(labelName), milestoneEQ(milestoneTitle))
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

    private BooleanExpression labelEq(String labelName) {
        if (StringUtils.isEmpty(labelName)) {
            return null;
        }
        return QLabel.label.name.like(labelName);
    }

    private BooleanExpression milestoneEQ(String milestoneTitle) {
        if (StringUtils.isEmpty(milestoneTitle)) {
            return null;
        }
        return QMilestone.milestone.title.like(milestoneTitle);
    }
}
