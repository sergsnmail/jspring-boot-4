package com.sergsnmail.jspringboot4.repository;

import com.sergsnmail.jspringboot4.exception.product.ProductNotFoundException;
import com.sergsnmail.jspringboot4.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component(value = "inMemory")
public class ProductInMemoryRepository implements ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1L, "Яблоко", 1.5f));
        products.add(new Product(2L, "Апельсин", 2.5f));
        products.add(new Product(3L, "Тыква", 5.0f));
        products.add(new Product(4L, "Помидор", 4.0f));
        products.add(new Product(5L, "Огурец", 2.5f));
        products.add(new Product(6L, "Виноград", 15.8f));
        products.add(new Product(7L, "Мандарин", 6.9f));
        products.add(new Product(8L, "Киви", 1.2f));
        products.add(new Product(9L, "Баклажан", 10.5f));
        products.add(new Product(10L, "Арбуз", 100.1f));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProduct(long id) throws ProductNotFoundException {
       return products.stream()
                .filter(a -> id == a.getId())
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(String.format("Product with id=%s does not exist",id)));
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product updatedProduct) {
        for (Product product : products) {
            if (updatedProduct.getId() == product.getId()){
                product.setTitle(updatedProduct.getTitle());
                product.setCost(updatedProduct.getCost());
            }
        }
    }

    @Override
    public void delete(long id) {
        products.removeIf(s -> s.getId() == id);
    }
}
