package com.isa.projectfinal.services;

import com.isa.projectfinal.models.UserModel;
import com.isa.projectfinal.models.UserPageModel;
import com.isa.projectfinal.models.UserRecipesModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {
    UserModel getUser(Integer id);
    List<UserModel> getAllUsers();
    UserPageModel getAllUsersPage(PageRequest pageRequest);
    List<UserRecipesModel> getAllUsersWithRecipes();
    UserModel create(UserModel user);
    UserModel update(UserModel user);
    void delete(Integer id);
}
