package com.sergsnmail.jspringboot4.controller.command.product.create;

import com.sergsnmail.jspringboot4.controller.command.Command;

public class ProductCreate extends Command<ProductCreateParam> {

    private ProductCreate(ProductCreateParam createParam) {
        this.parameter = createParam;
    }

    public static CreateBuilder builder () {
        return new CreateBuilder();
    }

    public static class CreateBuilder {
        private long id;
        private String title;
        private float cost;

        public CreateBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public CreateBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateBuilder setCost(float cost) {
            this.cost = cost;
            return this;
        }

        public ProductCreate build(){
            ProductCreateParam createParam = new ProductCreateParam();
            createParam.setId(this.id);
            createParam.setTitle(this.title);
            createParam.setCost(this.cost);
            return new ProductCreate(createParam);
        }
    }
}
