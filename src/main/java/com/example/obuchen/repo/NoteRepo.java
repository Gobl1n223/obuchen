package com.example.obuchen.repo;

import com.example.obuchen.entities.Note;
import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, Long> {
    /**проверить Лист
     */

    List<Note> findByUserId(Long userId);
}
