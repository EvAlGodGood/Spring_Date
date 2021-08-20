package com.geekbrains.webapp.services;

import com.geekbrains.webapp.model.Category;
import com.geekbrains.webapp.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Optional<Category> findByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> findByIdWithProducts(Long id) {
        return categoryRepository.findByIdWithProducts(id);
    }
}