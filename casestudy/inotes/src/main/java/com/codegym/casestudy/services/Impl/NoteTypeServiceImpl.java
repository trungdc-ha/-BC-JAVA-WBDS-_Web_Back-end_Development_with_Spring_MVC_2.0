package com.codegym.casestudy.services.Impl;

import com.codegym.casestudy.models.NoteType;
import com.codegym.casestudy.repositories.NoteRepository;
import com.codegym.casestudy.repositories.NoteTypeRepository;
import com.codegym.casestudy.services.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    NoteTypeRepository noteTypeRepository;
    @Override
    public List<NoteType> getAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public NoteType getNoteById(int id) {
        return noteTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        noteTypeRepository.deleteById(id);
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);
    }
}
