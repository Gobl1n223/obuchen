package com.example.obuchen.controllers;

import com.example.obuchen.entities.Note;
import com.example.obuchen.service.impl.NoteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //постраничный вывод с html
    //частично работает, ошибка при вызове, хз как фиксануть
    //TODO
    @GetMapping("note/all2/{pageNum}")
    public String getAllNotes2(@PathVariable("pageNum") Integer pageNum,  Model model) {
        Pageable firstPageWithTwoElements = PageRequest.of(pageNum, 10);
        Page<Note> page = noteService.getAll(firstPageWithTwoElements);
        model.addAttribute("title", page.get().collect(Collectors.toList()));
        //return page.get().collect(Collectors.toList());
        return "allNotes";
    }

}
