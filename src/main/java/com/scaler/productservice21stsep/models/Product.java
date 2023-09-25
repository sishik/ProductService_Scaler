package com.scaler.productservice21stsep.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product extends BaseModel{
    private String productTitle;
    private String productDescription;
    private double productPrice;
    private String productImageUrl;
    private Category productCategory;
}
