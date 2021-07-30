package com.example.obuchen.service;

import com.example.obuchen.entities.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAll();
    Note editNote (Note note);
    Note getByTitle(String title);
    void delete(Long id);
    Note addNote (Note note);
    List<Note> getAllByTitle(String title);
    List<Note> getLast3Notes();
}
