package com.isa.projectfinal.services;

import com.isa.projectfinal.models.RecipeModel;

import java.util.List;

public interface IRecipeService {
    RecipeModel getRecipe(Integer id);
    List<RecipeModel> getAllRecipes();
    List<RecipeModel> getAllRecipesWithIngredients();
    RecipeModel create(RecipeModel recipe);
    RecipeModel update(RecipeModel recipe);
    void delete(Integer id);
}
