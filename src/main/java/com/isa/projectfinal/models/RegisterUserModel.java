package com.isa.projectfinal.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
