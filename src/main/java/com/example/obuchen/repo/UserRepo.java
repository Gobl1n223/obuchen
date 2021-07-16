package com.example.obuchen.repo;

import com.example.obuchen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

}
