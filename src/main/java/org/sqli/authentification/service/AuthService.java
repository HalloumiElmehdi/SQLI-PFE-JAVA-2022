package org.sqli.authentification.service;

import org.sqli.authentification.dto.UserFormDto;
import org.sqli.authentification.dto.UserLoggedInDTO;

public interface AuthService {
    UserLoggedInDTO login(final UserFormDto userDto);
}
