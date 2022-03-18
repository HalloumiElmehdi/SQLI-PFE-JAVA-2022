package org.sqli.authentification.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class UserLoggedInDTO implements Serializable {
    private Long id;
    private String login;
    private String groupName;
    private boolean enabled;
    private int loginattempts;
}
