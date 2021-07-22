package com.example.obuchen.repo;

import com.example.obuchen.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface NoteRepo extends JpaRepository<Note, Long> {

        @Query("select n from Note n where n.title = :title")
        Note findByTitle(@Param("title") String title);

        //TODO
        @Query(value = "SELECT * FROM (SELECT * FROM Note ORDER BY id DESC LIMIT 3)Var1 ORDER BY id ASC;",nativeQuery = true)
        List<Note> findForTape();


}
