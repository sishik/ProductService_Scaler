package com.scaler.productservice21stsep.models;
import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
public class Category extends BaseModel{
    private String categoryTitle;
    private String categoryDescription;
    private List<Product>products;
}
