package project.myschelin.domain.user.repository;

import project.myschelin.domain.user.model.User;

public interface UserRepository {

    long insertUser(User user);
    User findUserById(long userId);
}
