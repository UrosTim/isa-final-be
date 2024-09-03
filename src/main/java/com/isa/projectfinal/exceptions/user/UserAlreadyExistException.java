package com.isa.projectfinal.exceptions.user;

import com.isa.projectfinal.exceptions.BaseException;

public class UserAlreadyExistException extends BaseException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
