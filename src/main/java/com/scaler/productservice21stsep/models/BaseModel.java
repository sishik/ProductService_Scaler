package com.scaler.productservice21stsep.models;

import java.sql.Date;
import lombok.*;
@Getter
@Setter
@ToString
public class BaseModel {
    private long ProductId;
    private Date created_at;
    private Date updated_at;
    private boolean is_deleted;
}
