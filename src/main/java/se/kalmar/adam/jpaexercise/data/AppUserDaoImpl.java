package se.kalmar.adam.jpaexercise.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.kalmar.adam.jpaexercise.model.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<AppUser> findById(int id) {
        return Optional.ofNullable(entityManager.find(AppUser.class, id));
    }

    @Override
    @Transactional
    public AppUser update(AppUser appuser) {
        return entityManager.merge(appuser);
    }

    @Override
    @Transactional
    public AppUser save(AppUser appuser) {
        if (appuser == null) {
            throw new IllegalArgumentException("Cant persist AppUser = " + appuser);
        }
        entityManager.persist(appuser);
        return appuser;
    }

    @Override
    @Transactional
    public boolean delete(AppUser appuser) {
        boolean deleted = false;
        entityManager.remove(appuser);
        if (!findById(appuser.getUserId()).isPresent()) {
            deleted = true;
        }

         return deleted;
    }
}
