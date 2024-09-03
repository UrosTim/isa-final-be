package com.isa.projectfinal.controllers;

import com.isa.projectfinal.models.UserModel;
import com.isa.projectfinal.models.UserPageModel;
import com.isa.projectfinal.models.UserRecipesModel;
import com.isa.projectfinal.repositories.IUserRecipesRepository;
import com.isa.projectfinal.repositories.IUserRepository;
import com.isa.projectfinal.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("{id}")
    public UserModel getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("with-recipes")
    public List<UserRecipesModel> getUserListWithRecipes() {
        return userService.getAllUsersWithRecipes();
    }

    @GetMapping("list")
    public List<UserModel> getUserList(){
        return userService.getAllUsers();
    }

    @GetMapping("page-list")
    public UserPageModel getUserPageList(Integer pageNumber, Integer pageSize){
        return userService.getAllUsersPage(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result){
        return ResponseEntity.ok(userService.create(userModel));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result){
        if (result.hasErrors()) {
            return new ResponseEntity<>("Failed to update!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(userService.update(userModel));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(Integer id) {
        userService.delete(id);
        return ResponseEntity.ok("");
    }
}
