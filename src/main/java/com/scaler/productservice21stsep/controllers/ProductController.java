package com.scaler.productservice21stsep.controllers;

import com.scaler.productservice21stsep.dtos.Productdtos;
import com.scaler.productservice21stsep.models.Product;
import com.scaler.productservice21stsep.services.ProductService;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) {
        ResponseEntity<Product> response = new ResponseEntity<>(productService.getSingleProduct(productId),org.springframework.http.HttpStatus.OK);
        return response;
        //return productService.getSingleProduct(productId).toString();
    }
    @PostMapping()
    public ResponseEntity<Product>createProduct(@RequestBody Productdtos productdtos) {
        Product newProduct = productService.createProduct(productdtos);
        ResponseEntity<Product> response = new ResponseEntity<>(newProduct,org.springframework.http.HttpStatus.CREATED);
        return response;
    }
    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId,Productdtos productdetails) {
        return "updating product by id";
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "deleting product by Id";
    }

}
