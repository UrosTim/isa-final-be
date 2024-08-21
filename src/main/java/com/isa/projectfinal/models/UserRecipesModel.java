package com.isa.projectfinal.models;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserRecipesModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<RecipeModel> recipes;
}
