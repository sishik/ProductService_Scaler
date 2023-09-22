package com.scaler.productservice21stsep.services;

import com.scaler.productservice21stsep.dtos.Productdtos;

public interface ProductService {
    String getAllProducts();

    String getSingleProduct(Long productId);

    String createProduct(Productdtos productdtos);

    String updateProduct();

    String deleteProduct();
}
