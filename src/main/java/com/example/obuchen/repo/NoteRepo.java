package com.example.obuchen.repo;

import com.example.obuchen.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
//Я не ебу что это такое блядь
@Service
@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

        @Query("select n from Note n where n.title = :title")
        Note findByTitle(@Param("title") String title);

        // больше не используется, временно не удалять
/*
        @Query(value = "SELECT * FROM (SELECT * FROM Note ORDER BY id DESC LIMIT 3)Var1 ORDER BY id DESC ;",nativeQuery = true)
        List<Note> findForTape();
*/

        @Query(value = "SELECT * FROM Note ORDER BY id DESC LIMIT 3", nativeQuery = true)
        List<Note> findLast3Notes();

        // ORDER BY id ASC LIMIT 3 Вот эта херня выводит в обратном порядке и можно с последних записей идти для страниц

        List<Note> findAllByTitle(String title);

        List<Note> findByUserId(Long userId);

}
