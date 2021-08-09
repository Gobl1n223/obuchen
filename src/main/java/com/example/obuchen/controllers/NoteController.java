package com.example.obuchen.controllers;

import com.example.obuchen.entities.Note;
import com.example.obuchen.entities.User;
import com.example.obuchen.service.impl.NoteServiceImpl;

import com.example.obuchen.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NoteController {

    @Autowired
    private NoteServiceImpl noteService;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping
    public String notes(Model model) {
        List<Note> notes = noteService.getLast3Notes();
        model.addAttribute("notes", notes);
       return "index";
    }

    @GetMapping(value = "noteSearch")
    public String noteSearch(@RequestParam(value = "title", required = false)String title, Model model) {
        List<Note> titles = noteService.getAllByTitle(title);
        model.addAttribute("title", titles);
        return "noteSearch";
    }


    @GetMapping("note/all")
    @ResponseBody
    public String getAllNotes2() {
        return "redirect:/url/note/all/0";
    }


    //постраничный вывод без html
    @GetMapping("note/all/{pageNum}")
    @ResponseBody
    public List<Note> getAllNotes(@PathVariable("pageNum") Integer pageNum) {
        Pageable firstPageWithTwoElements = PageRequest.of(pageNum, 10);
        Page<Note> page = noteService.getAll(firstPageWithTwoElements);
        return page.get().collect(Collectors.toList());
    }


    @GetMapping("note/user/{id}/{pageNum}")
    @ResponseBody
    public List<Note> getAllByUserId(@PathVariable("pageNum") Integer pageNum,@PathVariable("id") Long id) {
        Pageable firstPageWithTwoElements = PageRequest.of(pageNum, 10);
        Page<Note> page = noteService.getAllByUserId(firstPageWithTwoElements, id);
        return page.get().collect(Collectors.toList());
    }


    @PostMapping("note/new")
    @ResponseBody
    @PreAuthorize("hasAuthority('user:rights')")
    public ResponseEntity createNewNote(@RequestBody String noteText) {

        long userId = 0L;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userId = userService.getByEmail(
                    ((UserDetails)principal)
                            .getUsername()).get().getId();
        }

        String title = noteText.substring(0,noteText.indexOf("\n"));
        noteText = noteText.substring(noteText.indexOf("\n")+1);

        Note note = new Note(title, noteText, userId);
        noteService.addNote(note);

        return ResponseEntity.ok().build();
    }

}
