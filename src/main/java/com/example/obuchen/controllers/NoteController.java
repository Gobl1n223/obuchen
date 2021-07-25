package com.example.obuchen.controllers;

import com.example.obuchen.entities.Note;
import com.example.obuchen.entities.User;
import com.example.obuchen.repo.NoteRepo;
import com.example.obuchen.service.UserService;
import com.example.obuchen.service.impl.NoteServiceImpl;
import com.example.obuchen.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private NoteServiceImpl noteService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value = "note")
    public String notes(Model model)
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
   public String addNote(Principal principal, String title, String note)
   {
       User user = (User) userServiceImpl.loadUserByUsername(principal.getName());

       Note newNote = new Note();
       newNote.setTitle(title);
       newNote.setNote(note);
       newNote.setUserId(user.getId());

       noteRepo.save(newNote);

       return "redirect:/notes";
   }
    @GetMapping("/notes")
    public String notes(Principal principal, Model model)
    {
        User user = (User) userServiceImpl.loadUserByUsername(principal.getName());
        List<Note> notes = noteRepo.findByUserId(user.getId());
        model.addAttribute("notes", notes);
        model.addAttribute("user", user);

        return "notes";
    }

}
