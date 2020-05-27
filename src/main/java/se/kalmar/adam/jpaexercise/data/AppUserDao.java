package se.kalmar.adam.jpaexercise.data;

import se.kalmar.adam.jpaexercise.model.AppUser;

import java.util.Optional;

public interface AppUserDao {

    Optional<AppUser> findById(int id);
    AppUser update(AppUser appuser);
    AppUser save(AppUser appuser);
    boolean delete(AppUser appuser);
}
