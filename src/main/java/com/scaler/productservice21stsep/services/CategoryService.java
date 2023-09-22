package com.scaler.productservice21stsep.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {

    String getAllCategories();

    String getSingleCategory(Long categoryId);
}
