package com.isa.projectfinal.controllers;

import com.isa.projectfinal.mappers.RecipeMapper;
import com.isa.projectfinal.models.RecipeModel;

import com.isa.projectfinal.repositories.IRecipeRepository;
import com.isa.projectfinal.services.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipe")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("{id}")
    public RecipeModel getRecipe(@PathVariable Integer id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping("with-ingredients")
    public List<RecipeModel> getRecipeWithIngredients() {
        return recipeService.getAllRecipesWithIngredients();
    }

    @GetMapping("list")
    public List<RecipeModel> getRecipeList() {
        return recipeService.getAllRecipes();
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid RecipeModel recipeModel, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<>("Unsuccessful.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(recipeService.create(recipeModel), HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid RecipeModel recipeModel, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<>("Unsuccessful.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(recipeService.update(recipeModel), HttpStatus.CREATED);
    }
}
