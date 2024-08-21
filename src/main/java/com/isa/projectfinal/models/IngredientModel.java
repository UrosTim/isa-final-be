package com.isa.projectfinal.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class IngredientModel {
    private Integer id;
    private String name;
    private String description;
    private List<RecipeModel> recipes;
}
