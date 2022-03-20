package org.sqli.authentification.service;

import lombok.extern.slf4j.Slf4j;
import org.sqli.authentification.dao.UserDao;
import org.sqli.authentification.dto.UserFormDto;
import org.sqli.authentification.dto.UserLoggedInDTO;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.exception.AuthFailedException;
import org.sqli.authentification.repository.UserRepository;

@Service
@Slf4j
public class AuthServiceImp implements AuthService {

    private final UserDao userDao;
    private final UserRepository userRepository;

    public AuthServiceImp(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    @Override
    public UserLoggedInDTO login(UserFormDto userFormDto) {
        log.info("login attempt with data {}", userFormDto);
        return userDao
                    .findByLoginAndPassword(userFormDto.getLogin(), userFormDto.getPassword())
                                            .map(user -> mapToLoggedInDTO(user, new UserLoggedInDTO()))
    }


    /**
     * @param user
     * @param userLoggedInDTO
     * @return an object mapped from the input user into UserLoggedInDTO
     */
    private UserLoggedInDTO mapToLoggedInDTO(final User user, final UserLoggedInDTO userLoggedInDTO) {
        userLoggedInDTO.setId(user.getId());
        userLoggedInDTO.setLogin(user.getLogin());
        userLoggedInDTO.setGroupName(user.getGroup().getName());
        return userLoggedInDTO;
    }

}
