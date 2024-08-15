package com.isa.projectfinal.controllers;

import com.isa.projectfinal.models.RecipeModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipe")
public class RecipeController {
    @GetMapping("get-list")
    public List<String> getRecipeList() {
        return List.of("Ramen", "Sushi");
    }

    @PostMapping("create")
    public RecipeModel create(@RequestBody RecipeModel recipeModel){
        return recipeModel;
    }
}
