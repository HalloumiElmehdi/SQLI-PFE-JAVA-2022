package org.sqli.authentification.service.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.user.UserDao;
import org.sqli.authentification.exception.NotFoundException;

import javax.transaction.Transactional;

@Service
@Slf4j
@Transactional
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public SuccessMessageResponse deleteByLogin(final String login) {
        Long deleted = userDao.deleteByLogin(login);
        log.info("deleted   {}", deleted);
        if(deleted > 0)
            return new SuccessMessageResponse("Login '" + login + "' is deleted");

        throw new NotFoundException("Login '" + login + "' is not found");
    }



}
