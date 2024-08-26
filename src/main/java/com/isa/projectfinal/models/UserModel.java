package com.isa.projectfinal.models;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private Integer id;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;
    private String role;
}
