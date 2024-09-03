package com.isa.projectfinal.mappers;

import com.isa.projectfinal.entities.User;
import com.isa.projectfinal.models.RegisterUserModel;
import com.isa.projectfinal.models.UserModel;
import com.isa.projectfinal.models.UserPageModel;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserModel toModel(User entity) {
        return UserModel.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .role(entity.getRole())
                .build();
    }

    public static List<UserModel> toListModel(List<User> entityList) {
        var list = new ArrayList<UserModel>();
        for (var entity : entityList) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static UserPageModel toModelPageList(Page<User> entityPage) {
        return UserPageModel.builder()
                .users(toListModel(entityPage.getContent()))
                .totalPages(entityPage.getTotalPages())
                .totalElements(entityPage.getTotalElements())
                .build();
    }

    public static User toEntity(UserModel model, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setId(model.getId());
        user.setEmail(model.getEmail());
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        user.setRole(model.getRole());
        return user;
    }

    public static User toEntity(RegisterUserModel model, PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        user.setRole(model.getRole());
        return user;
    }
}
