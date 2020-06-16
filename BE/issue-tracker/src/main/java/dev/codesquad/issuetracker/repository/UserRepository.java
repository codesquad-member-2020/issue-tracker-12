package dev.codesquad.issuetracker.repository;

import dev.codesquad.issuetracker.common.exception.DataNotFoundException;
import dev.codesquad.issuetracker.domain.user.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public Optional<User> findOne(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public List<User> findList(List<Long> ids) {
        List<User> users = new ArrayList<>();
        if (ids.size() == 0) {
            return users;
        }
        for (Long id : ids) {
            User user = findOne(id).orElseThrow(() -> new DataNotFoundException("User is not exist"));
            users.add(user);
        }
        return users;
    }
}
