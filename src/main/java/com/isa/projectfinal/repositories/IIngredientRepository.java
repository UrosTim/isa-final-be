package com.isa.projectfinal.repositories;

import com.isa.projectfinal.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIngredientRepository extends JpaRepository<Ingredient, Integer> {
}
