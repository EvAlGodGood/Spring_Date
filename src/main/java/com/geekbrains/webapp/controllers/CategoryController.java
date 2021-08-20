package com.geekbrains.webapp.controllers;

import com.geekbrains.webapp.dtos.CategoryDto;
import com.geekbrains.webapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return new CategoryDto(categoryService.findByIdWithProducts(id).get());
    }
}