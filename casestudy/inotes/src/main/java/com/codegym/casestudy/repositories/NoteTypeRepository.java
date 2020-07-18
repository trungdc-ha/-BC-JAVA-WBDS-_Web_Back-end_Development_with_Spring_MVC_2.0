package com.codegym.casestudy.repositories;

import com.codegym.casestudy.models.NoteType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteTypeRepository extends JpaRepository<NoteType,Integer> {
}
