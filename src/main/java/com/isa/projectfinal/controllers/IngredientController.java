package com.isa.projectfinal.controllers;

import com.isa.projectfinal.entities.Ingredient;
import com.isa.projectfinal.mappers.IngredientMapper;
import com.isa.projectfinal.models.IngredientModel;
import com.isa.projectfinal.repositories.IIngredientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ingredient")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IngredientController {
    private final IIngredientRepository ingredientRepository;

    @GetMapping("list")
    public List<IngredientModel> getIngredientList() {
        return IngredientMapper.toListModel(ingredientRepository.findAll());
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid IngredientModel ingredientModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Unsuccessful.", HttpStatus.BAD_REQUEST);
        }

        var entity = IngredientMapper.toEntity(ingredientModel);
        ingredientRepository.save(entity);

        return new ResponseEntity<>(ingredientModel, HttpStatus.CREATED);
    }
}
