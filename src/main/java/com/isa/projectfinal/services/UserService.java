package com.isa.projectfinal.services;

import com.isa.projectfinal.exceptions.user.UserAlreadyExistException;
import com.isa.projectfinal.exceptions.user.UserException;
import com.isa.projectfinal.mappers.UserMapper;
import com.isa.projectfinal.mappers.UserRecipesMapper;
import com.isa.projectfinal.models.UserModel;
import com.isa.projectfinal.models.UserPageModel;
import com.isa.projectfinal.models.UserRecipesModel;
import com.isa.projectfinal.repositories.IUserRecipesRepository;
import com.isa.projectfinal.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IUserRecipesRepository userRecipesRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserModel getUser(Integer id) {
        return UserMapper.toModel(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found")));
    }

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
    public UserModel create(UserModel model) {
        var existingUser = userRepository.findByEmail(model.getEmail());

        if (existingUser.isPresent())
            throw new UserAlreadyExistException("User with email " + model.getEmail() + " already exists");

        return UserMapper.toModel(userRepository.save(UserMapper.toEntity(model, passwordEncoder)));
    }

    @Override
    public UserModel update(UserModel user) {
        try {
            return UserMapper.toModel(userRepository.save(UserMapper.toEntity(user, passwordEncoder)));
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        var entity = userRepository.findById(id).orElseThrow(() -> new UserException("User Not Found"));
        userRepository.delete(entity);
    }
}
