package com.example.obuchen.controllers;

import com.example.obuchen.entities.Note;
import com.example.obuchen.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class NoteController {
    @Autowired
    private NoteRepo noteRepo;

    @RequestMapping(value = "note", method = RequestMethod.GET)
    public String notes(@RequestParam(value = "title", required = false)String title, Model model)
    {
        List<Note> notes = noteRepo.findForTape();
        Collections.reverse(notes);
        System.out.println(notes);
        model.addAttribute("notes", notes);
        model.addAttribute("noteSearch", noteRepo.findAllByTitle(title));
       return "index";
    }
    @RequestMapping(value = "noteSearch", method = RequestMethod.GET)
    public String notesS(@RequestParam(value = "title", required = false)String title, Model model)
    {
        List<Note> notes = noteRepo.findForTape();
        Collections.reverse(notes);
        System.out.println(notes);
        model.addAttribute("notes", notes);
        List<Note> titles = noteRepo.findAllByTitle(title);
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

}
