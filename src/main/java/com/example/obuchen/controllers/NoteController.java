package com.example.obuchen.controllers;

import com.example.obuchen.entities.Note;
import com.example.obuchen.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class NoteController {
    @Autowired
    private NoteRepo noteRepo;

    @GetMapping("/")
    public String notes(Model model)
    {
        List<Note> notes = noteRepo.findForTape();
        Collections.reverse(notes);
        System.out.println(notes);
        model.addAttribute("notes", notes);

        return "index";
    }


}
