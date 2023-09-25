package com.scaler.productservice21stsep.services;

import com.scaler.productservice21stsep.dtos.Productdtos;
import com.scaler.productservice21stsep.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product createProduct(Productdtos productdtos);

    Product updateProduct(Long productId, Productdtos productdetails);

    Product deleteProduct(Long productId);
}
