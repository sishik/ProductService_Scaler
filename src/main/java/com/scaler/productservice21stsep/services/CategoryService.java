package com.scaler.productservice21stsep.services;

import com.scaler.productservice21stsep.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getSingleCategory(Long categoryId);
}
