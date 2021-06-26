package com.sergsnmail.jspringboot4.controller.command.product.update;


import com.sergsnmail.jspringboot4.controller.command.Command;

public class ProductUpdate extends Command<ProductUpdateParam> {

    private ProductUpdate(ProductUpdateParam updateParam) {
        this.parameter = updateParam;
    }

    public static UpdateBuilder builder () {
        return new UpdateBuilder();
    }

    public static class UpdateBuilder {
        private long id;
        private String title;
        private float cost;

        public UpdateBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public UpdateBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateBuilder setCost(float cost) {
            this.cost = cost;
            return this;
        }

        public ProductUpdate build(){
            ProductUpdateParam updateParam = new ProductUpdateParam();
            updateParam.setId(this.id);
            updateParam.setTitle(this.title);
            updateParam.setCost(this.cost);
            return new ProductUpdate(updateParam);
        }
    }
}
