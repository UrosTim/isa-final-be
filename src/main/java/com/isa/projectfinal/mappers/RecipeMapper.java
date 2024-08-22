package com.isa.projectfinal.mappers;

import com.isa.projectfinal.entities.Recipe;
import com.isa.projectfinal.models.RecipeModel;

import java.util.ArrayList;
import java.util.List;

public class RecipeMapper {
    public static RecipeModel toModel(Recipe entity) {
        return RecipeModel.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .imagePath(entity.getImagePath())
                .build();
    }

    public static List<RecipeModel> toListModel(List<Recipe> entityList) {
        var list = new ArrayList<RecipeModel>();
        for (var entity : entityList) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static Recipe toEntity(RecipeModel model) {
        Recipe entity = new Recipe();
        entity.setId(model.getId());
        entity.setTitle(model.getTitle());
        entity.setDescription(model.getDescription());
        entity.setImagePath(model.getImagePath());
        return entity;
    }

    public static RecipeModel toModelWithIngredients(Recipe entity) {
        return RecipeModel.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .imagePath(entity.getImagePath())
                .ingredients(IngredientMapper.toListModel(entity.getIngredients()))
                .build();
    }

    public static List<RecipeModel> toListModelWithIngredients(List<Recipe> entityList) {
        var list = new ArrayList<RecipeModel>();
        for (var entity : entityList) {
            list.add(toModelWithIngredients(entity));
        }
        return list;
    }

    public static RecipeModel toModelWithUser(Recipe recipe) {
        return RecipeModel.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .imagePath(recipe.getImagePath())
                .user(UserRecipesMapper.toModel(recipe.getUser()))
                .build();
    }
    public static List<RecipeModel> toListModelWithUser(List<Recipe> entityList) {
        var list = new ArrayList<RecipeModel>();
        for (var entity : entityList) {
            list.add(toModelWithUser(entity));
        }
        return list;
    }
}
