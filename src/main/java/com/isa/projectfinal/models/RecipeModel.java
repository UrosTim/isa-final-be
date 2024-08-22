package com.isa.projectfinal.models;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecipeModel {
    private Integer id;

    @NotNull
    private String title;

    private String description;
    private String imagePath;
    private List<IngredientModel> ingredients;
    private UserRecipesModel user;
}
