package com.isa.projectfinal.mappers;

import com.isa.projectfinal.entities.UserRecipes;
import com.isa.projectfinal.models.UserRecipesModel;

import java.util.ArrayList;
import java.util.List;

public class UserRecipesMapper {
    public static UserRecipesModel toModel(UserRecipes entity) {
        return UserRecipesModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .recipes(RecipeMapper.toListModel(entity.getRecipes()))
                .build();
    }

    public static List<UserRecipesModel> toListModel(List<UserRecipes> entityList) {
        var list = new ArrayList<UserRecipesModel>();
        for (var entity : entityList) {
            list.add(toModel(entity));
        }
        return list;
    }
}
