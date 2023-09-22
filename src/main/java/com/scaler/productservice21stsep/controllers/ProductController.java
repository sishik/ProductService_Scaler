package com.scaler.productservice21stsep.controllers;

import com.scaler.productservice21stsep.dtos.Productdtos;
import com.scaler.productservice21stsep.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping()
    public String getAllProducts() {
        return "returning all products";
    }
    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId) {
        return "returning single product by id"+productId;
    }
    @PostMapping()
    public String createProduct(@RequestBody Productdtos productdtos) {
        return "creating product"+productdtos;
    }
    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId) {
        return "updating product by id";
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "deleting product by Id";
    }

}
