package com.scaler.productservice21stsep.controllers;

import com.scaler.productservice21stsep.dtos.CategoryDtos;
import com.scaler.productservice21stsep.models.Category;
import com.scaler.productservice21stsep.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping()
    public String getAllCategories() {
        return "returning all categories";
    }
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getSingleCategory(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.getSingleCategory(categoryId);
        return ResponseEntity.ok(category);
        //return "returning single category by id";
    }
    @PostMapping
    public String createCategory(@RequestBody CategoryDtos categoryDtos) {
        return "creating category"+categoryDtos;
    }
}
