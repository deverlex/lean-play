package services;

import com.google.inject.ImplementedBy;
import models.User;
import services.impl.TripiUserImpl;

@ImplementedBy(TripiUserImpl.class)
public interface TripiUser {

    boolean createUser(User user);

    boolean deleteUser(int id);
}
