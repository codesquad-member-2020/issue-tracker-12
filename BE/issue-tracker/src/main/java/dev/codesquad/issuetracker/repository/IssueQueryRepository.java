package dev.codesquad.issuetracker.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.codesquad.issuetracker.domain.Status;
import dev.codesquad.issuetracker.domain.issue.Issue;
import dev.codesquad.issuetracker.domain.issue.QComment;
import dev.codesquad.issuetracker.domain.issue.QIssue;
import dev.codesquad.issuetracker.domain.label.QLabel;
import dev.codesquad.issuetracker.domain.milestone.QMilestone;
import dev.codesquad.issuetracker.domain.user.QUser;
import dev.codesquad.issuetracker.domain.user.User;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class IssueQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Issue> findFilteredIssue(Status status, String author, String labelName,
        String milestoneTitle, String assignee, String commentAuthor) {
        QIssue issue = QIssue.issue;
        QUser user = QUser.user;
        QLabel label = QLabel.label;
        QMilestone milestone = QMilestone.milestone;
        QComment comment = QComment.comment;
        JPAQueryFactory query = new JPAQueryFactory(em);

        return query
            .select(issue)
            .distinct()
            .from(issue)
            .leftJoin(issue.user, user)
            .leftJoin(issue.labels, label)
            .leftJoin(issue.milestone, milestone)
            .leftJoin(issue.comments, comment)
            .where(statusEq(status), authorEq(author), labelEq(labelName),
                milestoneEQ(milestoneTitle), assigneeEq(assignee), commentUserEq(commentAuthor))
            .limit(100)
            .fetch();
    }

    private BooleanExpression statusEq(Status status) {
        if (Objects.isNull(status)) {
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

    private BooleanExpression assigneeEq(String assignee) {
        if (StringUtils.isEmpty(assignee)) {
            return null;
        }
        User user = findByGithubId(assignee);
        if (Objects.isNull(user)) {
            return null;
        }
        return QIssue.issue.users.contains(user);
    }

    private BooleanExpression commentUserEq(String commentAuthor) {
        if (StringUtils.isEmpty(commentAuthor)) {
            return null;
        }
        return QComment.comment.user.githubId.like(commentAuthor);
    }

    public User findByGithubId(String githubId) {
        return em.createQuery("select u from User u where u.githubId = :githubId", User.class)
            .setParameter("githubId", githubId).getResultList().stream().findFirst().orElse(null);
    }
}
