package com.example.obuchen.service.impl;

import com.example.obuchen.entities.Note;
import com.example.obuchen.repo.NoteRepo;
import com.example.obuchen.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;

    @Override
    public Page<Note> getAll(Pageable pageable) {

        return noteRepo.findAll(pageable);
    }

    @Override
    public Note editNote(Note note) {
        return noteRepo.saveAndFlush(note);
    }

    @Override
    public Note getByTitle(String title) {
        return noteRepo.findByTitle(title);
    }

    @Override
    public void delete(Long id) {
        noteRepo.deleteById(id);
    }

    @Override
    public Note addNote(Note note) {
        return noteRepo.saveAndFlush(note);
    }

    @Override
    public List<Note> getLast3Notes() {
        return noteRepo.findLast3Notes();
    }

    @Override
    public List<Note> getAllByTitle(String title) {
        return noteRepo.findAllByTitle(title);
    }


}
