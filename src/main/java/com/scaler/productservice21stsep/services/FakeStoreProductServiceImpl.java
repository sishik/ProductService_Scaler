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
import java.util.HashMap;
import java.util.Map;

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
    public Product updateProduct(Long productId, Productdtos productdetails) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        // Define the URL with the {Id} placeholder for the productId
        String url = "https://fakestoreapi.com/products/{Id}";

        // Create a map for URL parameters (in this case, for the {Id} placeholder)
        Map<String, Long> urlParams = new HashMap<>();
        urlParams.put("Id", productId);

        // Make a PUT request to update the product
        restTemplate.put(url, productdetails, urlParams);

        // Now that the update has been performed, create a Product object manually
        Product updatedProduct = new Product();
        updatedProduct.setProductId(productId); // Assuming productId remains the same
        updatedProduct.setProductTitle(productdetails.getTitle());
        updatedProduct.setProductDescription(productdetails.getDescription());
        updatedProduct.setProductPrice(productdetails.getPrice());
        Category category = new Category();
        category.setCategoryTitle(productdetails.getCategory());
        updatedProduct.setProductCategory(category);
        updatedProduct.setProductImageUrl(productdetails.getImageUrl());
        updatedProduct.setUpdated_at(productdetails.getUpdated_at());

        return updatedProduct;
    }

    @Override
    public Product deleteProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        // Define the URL with the {Id} placeholder for the productId
        String url = "https://fakestoreapi.com/products/{Id}";
        restTemplate.delete(url, productId);
        Product deletedProduct = new Product();
        deletedProduct.setProductId(productId);
        deletedProduct.set_deleted(true);
        return deletedProduct;
    }
}
