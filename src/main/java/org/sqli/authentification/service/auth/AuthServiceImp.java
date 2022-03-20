package org.sqli.authentification.service.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.user.UserDao;
import org.sqli.authentification.dto.UserFormDTO;
import org.sqli.authentification.dto.UserLoggedInDTO;
import org.sqli.authentification.dto.UserRegisterFormDTO;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.entitie.UserGroup;
import org.sqli.authentification.exception.AuthException;
import org.sqli.authentification.exception.NotFoundException;
import org.sqli.authentification.repository.UserGroupRepository;
import org.sqli.authentification.repository.UserRepository;

@Service
@Slf4j
public class AuthServiceImp implements AuthService {

    private final UserDao userDao;
    private final UserRepository userRepository;
    private final UserGroupRepository userGroupRepository;

    public AuthServiceImp(UserDao userDao, UserRepository userRepository, UserGroupRepository userGroupRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public UserLoggedInDTO login(UserFormDTO userFormDto) {
        log.info("login attempt with data {}", userFormDto);
        UserLoggedInDTO userLoggedIn = userDao
                .findByLoginAndPassword(userFormDto.getLogin(), userFormDto.getPassword())
                .map(user -> mapToLoggedInDTO(user, new UserLoggedInDTO()))
                .orElseThrow(() -> new AuthException("Authentication error"));

        if(userLoggedIn.getLoginattempts() >= 3) {
            throw new AuthException("You have reached 3 failed authentication attempts, your account will be disabled");
        }
        if(!userLoggedIn.isEnabled()) {
            throw new AuthException("User disabled");
        }

        return userLoggedIn;
    }

    @Override
    public UserLoggedInDTO register(UserRegisterFormDTO userRegisterFormDTO) {
        log.info("registering new user with data {}", userRegisterFormDTO);
        final UserGroup userGroup = userGroupRepository
                        .findByName(userRegisterFormDTO.getGroup())
                        .orElseThrow(() -> new NotFoundException("Group '" + userRegisterFormDTO.getGroup() + "' is not valid"));
        final User user = User.builder().build();
        mapToEntity(userRegisterFormDTO, user);
        user.setGroup(userGroup);
        userRepository.save(user);

        return mapToLoggedInDTO(user, new UserLoggedInDTO());
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
        userLoggedInDTO.setEnabled(user.isEnabled());
        userLoggedInDTO.setLoginattempts(user.getLoginattempts());
        return userLoggedInDTO;
    }


    private User mapToEntity(final UserRegisterFormDTO userRegisterFormDTO, User user) {
        user.setLogin(userRegisterFormDTO.getLogin());
        user.setPassword(userRegisterFormDTO.getPassword());
        return user;
    }

}
