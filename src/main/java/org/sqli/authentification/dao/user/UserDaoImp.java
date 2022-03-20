package org.sqli.authentification.dao.user;

import org.springframework.stereotype.Repository;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.repository.UserRepository;

import java.util.Optional;

@Repository
public class UserDaoImp implements UserDao {

    private final UserRepository userRepository;

    public UserDaoImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public Long deleteByLogin(String login) {
        return userRepository.deleteByLogin(login);
    }


}
