package com.scaler.productservice21stsep.services;

import com.scaler.productservice21stsep.dtos.Productdtos;
import com.scaler.productservice21stsep.models.Category;
import com.scaler.productservice21stsep.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<Productdtos[]> lists = restTemplate.getForEntity("https://fakestoreapi.com/products",Productdtos[].class);
        List<Product>list_of_product = new ArrayList<>();
        for(Productdtos productdtos:lists.getBody()){
            Product product = new Product();
            product.setProductId(productdtos.getId());
            product.setProductTitle(productdtos.getTitle());
            product.setProductDescription(productdtos.getDescription());
            product.setProductPrice(productdtos.getPrice());
            Category category = new Category();
            category.setCategoryTitle(productdtos.getCategory());
            product.setProductCategory(category);
            product.setProductImageUrl(productdtos.getImageUrl());
            list_of_product.add(product);
        }
        return list_of_product;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<Productdtos> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{Id}",Productdtos.class,productId);
        Productdtos producdttos = response.getBody();
        Product product = new Product();
        product.setProductId(producdttos.getId());
        product.setProductTitle(producdttos.getTitle());
        product.setProductDescription(producdttos.getDescription());
        product.setProductPrice(producdttos.getPrice());
        Category category = new Category();
        category.setCategoryTitle(producdttos.getCategory());
        product.setProductCategory(category);
        product.setProductImageUrl(producdttos.getImageUrl());
        return product;
    }

    //Rest Template is used to make the rest calls to the server or 3rd party api's calls to the server and get the response from the server.
    @Override
    public Product createProduct(Productdtos productdtos) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<Productdtos> response = restTemplate.postForEntity("https://fakestoreapi.com/products",productdtos,Productdtos.class);
        //here postFor Entity is used because we are sending the data to the server and we are expecting the response from the server
        //and we are expecting the response in the form of Productdtos.class. here syntax is(postForEntity(url,object,object.class))
        Productdtos producdttos = response.getBody();
        Product product1 = new Product();
        product1.setProductId(producdttos.getId());
        product1.setProductTitle(producdttos.getTitle());
        product1.setProductDescription(producdttos.getDescription());
        product1.setProductPrice(producdttos.getPrice());
        Category category = new Category();
        category.setCategoryTitle(producdttos.getCategory());
        product1.setProductCategory(category);
        product1.setProductImageUrl(producdttos.getImageUrl());
        return product1;
    }

    @Override
    public Product updateProduct(Long productId, Product productdetails) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
