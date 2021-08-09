package com.example.obuchen.service;

import com.example.obuchen.entities.Note;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {
    Page<Note> getAll(Pageable pageable);
    Note editNote (Note note);
    Note getByTitle(String title);
    void delete(Long id);
    Note addNote (Note note);
    List<Note> getAllByTitle(String title);
    List<Note> getLast3Notes();
    Page<Note> getAllByUserId(Pageable pageable, Long id);
}
