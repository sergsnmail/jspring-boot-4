package com.sergsnmail.jspringboot4.controller.command.product.create;

import com.sergsnmail.jspringboot4.controller.command.Parameter;
import lombok.Data;

@Data
public class ProductCreateParam extends Parameter {
    private long id;
    private String title;
    private float cost;
}
