package com.scaler.productservice21stsep.services;

import com.scaler.productservice21stsep.dtos.Productdtos;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    @Override
    public String getAllProducts() {
        return null;
    }

    @Override
    public String getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public String createProduct(Productdtos productdtos) {
        return null;
    }

    @Override
    public String updateProduct() {
        return null;
    }

    @Override
    public String deleteProduct() {
        return null;
    }
}
