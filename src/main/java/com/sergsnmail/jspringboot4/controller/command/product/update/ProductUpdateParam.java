package com.sergsnmail.jspringboot4.controller.command.product.update;

import com.sergsnmail.jspringboot4.controller.command.Parameter;
import lombok.Data;

@Data
public class ProductUpdateParam extends Parameter {
    private long id;
    private String title;
    private float cost;
}
