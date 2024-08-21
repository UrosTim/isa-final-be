package com.isa.projectfinal.services;

import com.isa.projectfinal.mappers.UserMapper;
import com.isa.projectfinal.mappers.UserRecipesMapper;
import com.isa.projectfinal.models.UserModel;
import com.isa.projectfinal.models.UserPageModel;
import com.isa.projectfinal.models.UserRecipesModel;
import com.isa.projectfinal.repositories.IUserRecipesRepository;
import com.isa.projectfinal.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IUserRecipesRepository userRecipesRepository;

    @Override
    public List<UserModel> getAllUsers() {
        return UserMapper.toListModel(userRepository.findAll());
    }

    @Override
    public UserPageModel getAllUsersPage(PageRequest pageRequest) {
        return UserMapper.toModelPageList(userRepository.findAll(pageRequest));
    }

    @Override
    public List<UserRecipesModel> getAllUsersWithRecipes() {
        return UserRecipesMapper.toListModel(userRecipesRepository.findAll());
    }

    @Override
    public UserModel create(UserModel user) {
        return UserMapper.toModel(userRepository.save(UserMapper.toEntity(user)));
    }

    @Override
    public UserModel update(UserModel user) {
        return UserMapper.toModel(userRepository.save(UserMapper.toEntity(user)));
    }

    @Override
    public UserModel delete(Integer id) {
        return null;
    }
}
