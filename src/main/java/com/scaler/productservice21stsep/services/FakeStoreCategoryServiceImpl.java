package com.scaler.productservice21stsep.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getSingleCategory(Long categoryId) {
        return null;
    }
}