package org.sqli.authentification.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sqli.authentification.dto.UserLoggedInDTO;
import org.sqli.authentification.dto.UserRegisterFormDTO;
import org.sqli.authentification.service.AuthService;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<UserLoggedInDTO> register(@RequestBody final UserRegisterFormDTO userRegisterFormDTO) {
        return ResponseEntity.ok(authService.register(userRegisterFormDTO));
    }
}
