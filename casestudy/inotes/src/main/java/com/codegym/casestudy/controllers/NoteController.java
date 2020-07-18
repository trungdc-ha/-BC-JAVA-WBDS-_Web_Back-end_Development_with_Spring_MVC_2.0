package com.codegym.casestudy.controllers;

import com.codegym.casestudy.models.Note;
import com.codegym.casestudy.services.NoteService;
import com.codegym.casestudy.services.NoteTypeService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;
    @Autowired
    NoteTypeService noteTypeService;
    @GetMapping("/")
    public ModelAndView getHomePage(@RequestParam("s") Optional<String> s,@PageableDefault(value = 5) Pageable pageable){
        Page<Note> notes;
        ModelAndView modelAndView = new ModelAndView("note/list");
        if (s.isPresent()){
            notes = noteService.getAllByTitle(s.get(),pageable);
            modelAndView.addObject("search",s.get());
        }else {
            notes = noteService.getAll(pageable);
            modelAndView.addObject("search","");
        }
        modelAndView.addObject("notes",notes);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        ModelAndView modelAndView = new ModelAndView("note/create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("noteTypes", noteTypeService.getAll());
        return modelAndView;
    }
    @PostMapping("/create")
    public String saveNote(@ModelAttribute Note note){
        note.setNoteType(noteTypeService.getNoteById(note.getNoteType().getId()));
        noteService.save(note);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView getDeletePage(@PathVariable int id){
        return new ModelAndView("note/delete", "note", noteService.getNoteById(id));
    }
    @PostMapping("/delete")
    public String deleteNote(@ModelAttribute Note note){
        noteService.deleteById(note.getId());
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("note", noteService.getNoteById(id));
        modelAndView.addObject("noteTypes", noteTypeService.getAll());
        return modelAndView;
    }
    @PostMapping("/edit")
    public String EditNote(@ModelAttribute Note note){
        noteService.save(note);
        return "redirect:/";
    }
    @GetMapping("/export")
    public void exportFileCSV(HttpServletResponse response) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        String filename = "users.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<Note> writer = new StatefulBeanToCsvBuilder<Note>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        //write all users to csv file
        writer.write(noteService.getAll());
    }
}
