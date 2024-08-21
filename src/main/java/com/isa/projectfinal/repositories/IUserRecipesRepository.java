package com.isa.projectfinal.repositories;

import com.isa.projectfinal.entities.UserRecipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRecipesRepository extends JpaRepository<UserRecipes, Integer> {
}
