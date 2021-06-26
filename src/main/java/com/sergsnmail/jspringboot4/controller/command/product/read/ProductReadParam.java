package com.sergsnmail.jspringboot4.controller.command.product.read;

import com.sergsnmail.jspringboot4.controller.command.Parameter;
import lombok.Data;

@Data
public class ProductReadParam extends Parameter {
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
