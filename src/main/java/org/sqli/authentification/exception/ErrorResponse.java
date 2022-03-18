package org.sqli.authentification.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private Integer httpStatus;
    private String exception;
    private String error;
}
