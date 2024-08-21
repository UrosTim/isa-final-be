package com.isa.projectfinal.repositories;

import com.isa.projectfinal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
