package com.example.obuchen.service;

import com.example.obuchen.entities.Note;
import com.example.obuchen.entities.User;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> getAll();
    Note editNote (Note note);
    Note getByTitle(String title);
    void delete(Long id);
    Note addNote (Note note);
    List<Note> getForTape();
    List<Note> getAllByTitle(String title);
}
