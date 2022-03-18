package org.sqli.authentification.service;

import org.sqli.authentification.dto.UserFormDTO;
import org.sqli.authentification.dto.UserLoggedInDTO;
import org.sqli.authentification.dto.UserRegisterFormDTO;

public interface AuthService {
    UserLoggedInDTO login(final UserFormDTO userDto);
    UserLoggedInDTO register(final UserRegisterFormDTO userRegisterFormDTO);
}
