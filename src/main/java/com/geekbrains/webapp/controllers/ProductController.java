package com.geekbrains.webapp.controllers;

import com.geekbrains.webapp.dtos.ProductDto;
import com.geekbrains.webapp.exceptions.ResourceNotFoundException;
import com.geekbrains.webapp.model.Category;
import com.geekbrains.webapp.model.Product;
import com.geekbrains.webapp.repositories.ProductRepository;
import com.geekbrains.webapp.services.CategoryService;
import com.geekbrains.webapp.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public Page<ProductDto> findAll(@RequestParam(defaultValue = "1", name = "p") int pageIndex) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex - 1, 5).map(ProductDto::new);
    }
// Старый вариант без проверки на ошибку
//    @GetMapping("/{id}")
//    public ProductDto findById(@PathVariable Long id) {
//        return new ProductDto(productService.findById(id).get());
//    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return new ProductDto(productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product id = " + id + " not found")));
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        Category category = categoryService.findByTitle(productDto.getCategoryTitle()).get();
        product.setCategory(category);
        productService.save(product);
        return new ProductDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
