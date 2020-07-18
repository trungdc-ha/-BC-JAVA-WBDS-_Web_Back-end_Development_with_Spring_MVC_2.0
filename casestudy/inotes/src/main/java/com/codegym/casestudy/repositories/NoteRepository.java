package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    Page<Note> findAll(Pageable pageable);
    Page<Note> getAllByTitleContaining(String title, Pageable pageable);
}
