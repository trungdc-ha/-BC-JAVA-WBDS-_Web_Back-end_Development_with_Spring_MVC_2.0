package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.NoteType;
import com.codegym.casestudy.services.NoteService;
import com.codegym.casestudy.services.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/noteTypes")
public class NoteTypeController {
    @Autowired
    NoteTypeService noteTypeService;

    @GetMapping("/")
    public ModelAndView getHomePage(){
        return new ModelAndView("note_type/list","noteTypes",noteTypeService.getAll());
    }
    @GetMapping("/deletePage/{id}")
    public ModelAndView getDeletePage(@PathVariable int id){
        return new ModelAndView("note_type/delete","noteType",noteTypeService.getNoteById(id));
    }
    @GetMapping("/delete/{id}")
    public String deleteNoteType(@PathVariable int id){
        noteTypeService.deleteById(id);
        return "redirect:/noteTypes/";
    }

    @GetMapping("/editPage/{id}")
    public ModelAndView getEditPage(@PathVariable int id){
        return new ModelAndView("note_type/edit","noteType",noteTypeService.getNoteById(id));
    }
    @PostMapping("/edit")
    public String deleteNoteType(@ModelAttribute NoteType noteType){
        noteTypeService.save(noteType);
        return "redirect:/noteTypes/";
    }
    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        return new ModelAndView("note_type/create","noteType",new NoteType());
    }
    @PostMapping("/create")
    public String createNoteType(@ModelAttribute NoteType noteType){
        noteTypeService.save(noteType);
        return "redirect:/noteTypes/";
    }

}
