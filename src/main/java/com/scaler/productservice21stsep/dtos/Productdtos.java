package com.scaler.productservice21stsep.dtos;
import jakarta.annotation.Nullable;
import lombok.*;
@Getter
@Setter
@ToString
public class Productdtos {
    @Nullable
    private long Id;
    private String Title;
    private String Description;
    private double Price;
    private String imageUrl;
    private String category;
    private boolean is_deleted;
}
