package com.isa.projectfinal.services;

import com.isa.projectfinal.mappers.RecipeMapper;
import com.isa.projectfinal.models.RecipeModel;
import com.isa.projectfinal.repositories.IRecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService implements IRecipeService {

    private final IRecipeRepository recipeRepository;

    @Override
    public RecipeModel getRecipe(Integer id) {
        return RecipeMapper.toModel(recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found")));
    }

    @Override
    public List<RecipeModel> getAllRecipes() {
        return RecipeMapper.toListModel(recipeRepository.findAll());
    }

    @Override
    public List<RecipeModel> getAllRecipesWithIngredients() {
        return RecipeMapper.toListModelWithIngredients(recipeRepository.findAll());
    }

    @Override
    public RecipeModel create(RecipeModel recipe) {
        return RecipeMapper.toModel(recipeRepository.save(RecipeMapper.toEntity(recipe)));
    }

    @Override
    public RecipeModel update(RecipeModel recipe) {
        return RecipeMapper.toModel(recipeRepository.save(RecipeMapper.toEntity(recipe)));
    }


}
