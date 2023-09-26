package com.scaler.productservice21stsep.services;

import com.scaler.productservice21stsep.dtos.CategoryDtos;
import com.scaler.productservice21stsep.models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import java.util.List;
import java.util.ArrayList;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreCategoryServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public List<Category> getAllCategories() {
RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<CategoryDtos[]> lists = restTemplate.getForEntity("https://fakestoreapi.com/products/categories",CategoryDtos[].class);
        List<Category>list_of_category = new ArrayList<>();
        for(CategoryDtos categoryDtos:lists.getBody()){
            Category category = new Category();
            category.setCategoryTitle(categoryDtos.getName());
            list_of_category.add(category);
        }
        return list_of_category;
    }

    @Override
    public Category getSingleCategory(Long categoryId) {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<CategoryDtos> response = restTemplate.getForEntity("https://fakestoreapi.com/products/categories/{Id}",CategoryDtos.class,categoryId);
        CategoryDtos categoryDtos = response.getBody();
        Category category = new Category();
        category.setCategoryTitle(categoryDtos.getName());
        return category;


    }
}
