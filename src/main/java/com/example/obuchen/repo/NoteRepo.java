package com.example.obuchen.repo;

import com.example.obuchen.entities.Note;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {

        @Query("select n from Note n where n.title = :title")
        Note findByTitle(@Param("title") String title);


        @Query(value = "SELECT * FROM Note ORDER BY id DESC LIMIT 3", nativeQuery = true)
        List<Note> findLast3Notes();


        @Query("SELECT u from Note u WHERE u.title LIKE CONCAT ('%',:title,'%')")
        List<Note> findAllByTitle(@Param("title") String title1);

        Page<Note> findAll(Pageable pageable);

        Page<Note> findAllByUserId(Pageable pageable, Long id);

}
