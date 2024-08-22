package com.isa.projectfinal.services;

import com.isa.projectfinal.entities.User;
import com.isa.projectfinal.exceptions.user.UserAlreadyExistException;
import com.isa.projectfinal.mappers.UserMapper;
import com.isa.projectfinal.models.LoginResponseModel;
import com.isa.projectfinal.models.LoginUserModel;
import com.isa.projectfinal.models.RegisterUserModel;
import com.isa.projectfinal.models.UserModel;
import com.isa.projectfinal.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UserModel signup(RegisterUserModel model) {
        var user = UserMapper.toEntity(model, passwordEncoder);

        var existingUser = userRepository.findByEmail(model.getEmail());

        if (existingUser.isPresent())
            throw new UserAlreadyExistException("User with email " + model.getEmail() + " already exists");

        return UserMapper.toModel(userRepository.save(user));
    }

    public LoginResponseModel authenticate(LoginUserModel model) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        model.getEmail(),
                        model.getPassword()
                )
        );

        var authenticatedUser = userRepository.findByEmail(model.getEmail())
                .orElseThrow(()-> new UsernameNotFoundException("User with email " + model.getEmail() + " not found"));

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseModel loginResponse = new LoginResponseModel();
        loginResponse.setToken(jwtToken);

        return loginResponse;
    }
}
