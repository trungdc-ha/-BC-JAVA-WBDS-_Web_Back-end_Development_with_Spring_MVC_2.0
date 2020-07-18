package com.codegym.casestudy.services;

import com.codegym.casestudy.models.NoteType;


import java.util.List;

public interface NoteTypeService {
    List<NoteType> getAll();
    NoteType getNoteById(int id);
    void deleteById(int id);
    void save(NoteType noteType);
}
