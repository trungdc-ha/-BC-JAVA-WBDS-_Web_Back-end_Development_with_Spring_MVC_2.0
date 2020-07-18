package com.codegym.casestudy.services;

import com.codegym.casestudy.models.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface NoteService {
    List<Note> getAll();
    Page<Note> getAll(Pageable pageable);
    Page<Note> getAllByTitle(String title, Pageable pageable);
    Note getNoteById(int id);
    void deleteById(int id);
    void save(Note note);
//    void writeCsv(List<Note> notes);
}
