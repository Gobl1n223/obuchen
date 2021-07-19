package com.example.obuchen.repo;

import com.example.obuchen.entities.Note;
import com.example.obuchen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select n from User n where n.name = :name")
    User findByName2(@Param("name") String title);

}
