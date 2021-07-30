package com.example.obuchen.controllers;

import com.example.obuchen.entities.Note;
import com.example.obuchen.repo.NoteRepo;
import com.example.obuchen.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NoteController {

    @Autowired
    private NoteServiceImpl noteService;


    @GetMapping
    public String notes(Model model) {
        List<Note> notes = noteService.getLast3Notes();
        model.addAttribute("notes", notes);
       return "index";
    }

    @GetMapping(value = "noteSearch")
    public String notesS(@RequestParam(value = "title", required = false)String title, Model model) {
        List<Note> titles = noteService.getAllByTitle(title);
        model.addAttribute("title", titles);
        return "noteSearch";
    }


    @GetMapping("note/all")
    @ResponseBody
    public String getAllNotes2() {
        return "redirect:/url/note/all/0";
    }


    @GetMapping("note/all/{userId}")
    @ResponseBody
    public List<Note> getAllNotes(@PathVariable("userId") Integer id) {
        Pageable firstPageWithTwoElements = PageRequest.of(id, 10);
        Page<Note> page = noteService.getAll(firstPageWithTwoElements);
        return page.get().collect(Collectors.toList());
    }

}
