package com.isa.projectfinal.controllers;

import com.isa.projectfinal.models.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping("get-list")
    public List<String> getUserList(){
        return List.of("Mary", "Jane");
    }

    @PostMapping("create")
    public UserModel create(@RequestBody UserModel userModel){
        return userModel;
    }
}
