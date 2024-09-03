package com.isa.projectfinal.controllers;

import com.isa.projectfinal.models.LoginUserModel;
import com.isa.projectfinal.models.RegisterUserModel;
import com.isa.projectfinal.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterUserModel model) {
        return ResponseEntity.ok(authenticationService.signup(model));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginUserModel model) {
        return ResponseEntity.ok(authenticationService.authenticate(model));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(authenticationService.refreshToken(request, response));
    }
}
