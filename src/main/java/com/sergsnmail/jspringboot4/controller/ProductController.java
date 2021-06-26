package com.sergsnmail.jspringboot4.controller;

import com.sergsnmail.jspringboot4.controller.command.product.create.ProductCreate;
import com.sergsnmail.jspringboot4.controller.command.product.delete.ProductDelete;
import com.sergsnmail.jspringboot4.controller.command.product.read.ProductRead;
import com.sergsnmail.jspringboot4.controller.command.product.update.ProductUpdate;
import com.sergsnmail.jspringboot4.exception.product.ProductNotFoundException;
import com.sergsnmail.jspringboot4.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("avg_cost", productService.calcAvgCost());
        return "products";
    }

    @GetMapping("/products/remove/{id}")
    public String deleteProduct(@PathVariable Long id) {
        ProductDelete deleteCommand = ProductDelete.builder()
                .setId(id)
                .build();
        productService.delete(deleteCommand.getParameter());
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(Model model, @PathVariable Long id) {
        ProductRead readCommand = ProductRead.builder()
                .setId(id)
                .build();
        try {
            model.addAttribute("product", productService.read(readCommand.getParameter()));
        } catch (ProductNotFoundException e) {
            return "prod_not_found";
        }
        return "edit";
    }

    @PostMapping("/products/add")
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Float cost) {
        ProductCreate createCommand = ProductCreate.builder()
                .setId(id)
                .setTitle(title)
                .setCost(cost)
                .build();
        productService.create(createCommand.getParameter());
        return "redirect:/products";
    }

    @PostMapping("/products/update")
    public String updateProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Float cost) {
        ProductUpdate updateCommand = ProductUpdate.builder()
                .setId(id)
                .setTitle(title)
                .setCost(cost)
                .build();
        try {
            productService.update(updateCommand.getParameter());
        } catch (ProductNotFoundException e) {
            return "prod_not_found";
        }
        return "redirect:/products";
    }
}
