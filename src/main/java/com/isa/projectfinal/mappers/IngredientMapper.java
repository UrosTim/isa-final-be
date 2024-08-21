package com.isa.projectfinal.mappers;

import com.isa.projectfinal.entities.Ingredient;
import com.isa.projectfinal.models.IngredientModel;

import java.util.ArrayList;
import java.util.List;

public class IngredientMapper {
    public static IngredientModel toModel(Ingredient entity) {
        return IngredientModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    public static List<IngredientModel> toListModel(List<Ingredient> entityList) {
        var list = new ArrayList<IngredientModel>();
        for (var entity : entityList) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static Ingredient toEntity(IngredientModel model) {
        Ingredient entity = new Ingredient();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        return entity;
    }
}
