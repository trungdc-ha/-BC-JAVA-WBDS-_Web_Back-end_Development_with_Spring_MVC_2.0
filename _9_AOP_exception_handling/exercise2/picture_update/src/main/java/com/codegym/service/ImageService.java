package com.codegym.service;

import com.codegym.model.Image;

public interface ImageService {
    Iterable<Image> findAll();

    Image findById(Long id);

    void save(Image blog);

    void remove(Long id);
}
