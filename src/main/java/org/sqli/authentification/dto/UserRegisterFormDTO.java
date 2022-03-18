package org.sqli.authentification.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterFormDTO {
    private String login;
    private String password;
    private String group;
}
