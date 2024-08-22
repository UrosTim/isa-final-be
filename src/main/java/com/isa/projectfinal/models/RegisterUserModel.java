package com.isa.projectfinal.models;

import lombok.Data;

@Data
public class RegisterUserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
