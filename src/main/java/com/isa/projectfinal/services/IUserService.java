package com.isa.projectfinal.services;

import com.isa.projectfinal.models.UserModel;
import com.isa.projectfinal.models.UserPageModel;
import com.isa.projectfinal.models.UserRecipesModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {
    List<UserModel> getAllUsers();
    UserPageModel getAllUsersPage(PageRequest pageRequest);
    List<UserRecipesModel> getAllUsersWithRecipes();
    UserModel create(UserModel user);
    UserModel update(UserModel user);
    UserModel delete(Integer id);
}
