package com.sergsnmail.jspringboot4.repository;

import com.sergsnmail.jspringboot4.exception.product.ProductNotFoundException;
import com.sergsnmail.jspringboot4.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
    Product getProduct(long id) throws ProductNotFoundException;
    void create (Product product);
    void update (Product product);
    void delete(long id);
}
