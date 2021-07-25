package com.example.obuchen.repo;

import com.example.obuchen.entities.Note;
import com.example.obuchen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
//Я не ебу что это такое блядь
@Service
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select n from User n where n.name = :name")
    User findByName2(@Param("name") String title);

    User findByUsername(String email);
    User findByName(String name);
    User findByGoogleUsername(String googleUsername);
    User findByGoogleName(String googleName);
}
