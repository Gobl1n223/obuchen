package com.example.obuchen.controllers;

import com.example.obuchen.entities.Note;
import com.example.obuchen.repo.NoteRepo;
import com.example.obuchen.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteServiceImpl noteService;


    @GetMapping(value = "note")
    public String notes(@RequestParam(value = "title", required = false)String title, Model model)
    {
        List<Note> notes = noteService.getLast3Notes();
        model.addAttribute("notes", notes);
       return "index";
    }
    @GetMapping(value = "noteSearch")
    public String notesS(@RequestParam(value = "title", required = false)String title, Model model)
    {
        List<Note> titles = noteService.getAllByTitle(title);
        model.addAttribute("title", titles);
        return "noteSearch";
    }

   /*@PostMapping("/note")
    public String noteSearch(Note note, Model model, String title)
   {
       List<Note> foundNote = noteRepo.findAllByTitle(title);
       model.addAttribute("foundTitle", foundNote);
       return "noteSearch";
   }*/
   @PostMapping("/addnote")
   public String addNote(String title, String note)
   {
       Note newNote = new Note();
       newNote.setTitle(title);
       newNote.setNote(note);

       noteService.addNote(newNote);

       return "redirect:/notes";
   }

}
