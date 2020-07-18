package com.blog.service.impl;

import com.blog.model.Category;
import com.blog.model.Writing;
import com.blog.repository.WritingRepository;
import com.blog.service.WritingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class WritingServiceImpl implements WritingService {
    @Autowired
    private WritingRepository writingRepository;
    @Override
    public Page<Writing> findAll(Pageable pageable) {
        return writingRepository.findAll(pageable);
    }

    @Override
    public Iterable<Writing> findAllNoSort() {
        return writingRepository.findAll();
    }

    @Override
    public Writing findById(Long id) {
        return writingRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Writing writing) {
        writingRepository.save(writing);
    }

    @Override
    public void remove(Long id) {
        writingRepository.deleteById(id);
    }

    @Override
    public Iterable<Writing> findAllByCategory(Category category) {
        return writingRepository.findAllByCategory(category);
    }

    @Override
    public Page<Writing> findAllByTittleContaining(String tittle, Pageable pageable) {
        return writingRepository.findAllByTittleContaining(tittle,pageable);
    }
}
