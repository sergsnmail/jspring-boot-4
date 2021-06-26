package com.sergsnmail.jspringboot4.service;

import com.sergsnmail.jspringboot4.controller.command.product.create.ProductCreateParam;
import com.sergsnmail.jspringboot4.controller.command.product.delete.ProductDeleteParam;
import com.sergsnmail.jspringboot4.controller.command.product.read.ProductReadParam;
import com.sergsnmail.jspringboot4.controller.command.product.update.ProductUpdateParam;
import com.sergsnmail.jspringboot4.exception.product.ProductNotFoundException;
import com.sergsnmail.jspringboot4.model.Product;
import com.sergsnmail.jspringboot4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void create(ProductCreateParam parameter) {
        Product newProduct = new Product(parameter.getId(), parameter.getTitle(), parameter.getCost());
        productRepository.create(newProduct);
    }

    public Product read(ProductReadParam parameter) throws ProductNotFoundException {
        return productRepository.getProduct(parameter.getId());
    }

    public void update(ProductUpdateParam parameter) throws ProductNotFoundException {
        Product product = productRepository.getProduct(parameter.getId());
        product.setTitle(parameter.getTitle());
        product.setCost(parameter.getCost());
        productRepository.update(product);
    }

    public void delete(ProductDeleteParam parameter) {
        productRepository.delete(parameter.getId());
    }

    public float calcAvgCost() {
        List<Product> products = productRepository.getProducts();
        float totalCost = 0;
        for (Product product : products) {
            totalCost +=product.getCost();
        }
        return totalCost/products.size();
    }

    public List<Product> getAllProducts(){
        return productRepository.getProducts();
    }
}
