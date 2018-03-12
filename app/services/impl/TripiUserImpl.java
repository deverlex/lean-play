package services.impl;

import models.User;
import services.TripiUser;

import javax.inject.Singleton;

@Singleton
public class TripiUserImpl implements TripiUser {

    @Override
    public boolean createUser(User user) {
        User.db().save(user);
        return user.getId() >= 0;
    }

    @Override
    public boolean deleteUser(int id) {
        return User.db().delete(User.class, id) == 1;
    }
}
