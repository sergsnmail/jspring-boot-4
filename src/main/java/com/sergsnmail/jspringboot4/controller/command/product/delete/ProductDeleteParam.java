package com.sergsnmail.jspringboot4.controller.command.product.delete;

import com.sergsnmail.jspringboot4.controller.command.Parameter;
import lombok.Data;

@Data
public class ProductDeleteParam extends Parameter {
    private long id;
}
