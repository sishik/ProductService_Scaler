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
        ResponseEntity<Product> response1 = new ResponseEntity<>(newProduct,org.springframework.http.HttpStatus.CREATED);
        return response1;
    }
    @PutMapping("/{productId}")
    public ResponseEntity<Product>updateProduct(@PathVariable("productId") Long productId,@RequestBody Productdtos productdetails) {
        Product updatedProduct = productService.updateProduct(productId,productdetails);
        ResponseEntity<Product> response2 = new ResponseEntity<>(updatedProduct,org.springframework.http.HttpStatus.OK);
        return response2;

        //return "updating product by id";
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Product>deleteProduct(@PathVariable("productId") Long productId) {
        Product deletedProduct = productService.deleteProduct(productId);
        ResponseEntity<Product> response3 = new ResponseEntity<>(deletedProduct,org.springframework.http.HttpStatus.OK);
        return response3;
        //return "deleting product by id";
    }

}
