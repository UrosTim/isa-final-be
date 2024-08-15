package com.isa.projectfinal.models;
import lombok.Data;

@Data
public class UserModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
