package com.isa.projectfinal.repositories;

import com.isa.projectfinal.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
}
