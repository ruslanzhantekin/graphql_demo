package com.dailybugle.website.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ProductRepository {

    private static final ProductEntity product1;
    private static final ProductEntity product2;
    private static final ProductEntity product3;

    static {
        product1 = new ProductEntity();
        product1.setId("1");
        product1.setTitle("Product#1");
        product1.setDescription("Description#1");
        product1.setPrice(100D);
        product1.setSku("101");

        product2 = new ProductEntity();
        product2.setId("2");
        product2.setTitle("Product#2");
        product2.setDescription("Description#2");
        product2.setPrice(200D);
        product2.setSku("102");

        product3 = new ProductEntity();
        product3.setId("3");
        product3.setTitle("Product#3");
        product3.setDescription("Description#3");
        product3.setPrice(300D);
        product3.setSku("103");
    }

    public List<ProductEntity> findAll() {
        return List.of(product1, product2, product3);
    }

    public ProductEntity findById(String id) {
        if (id.equals("1")) return product1;
        if (id.equals("2")) return product2;
        if (id.equals("3")) return product3;

        return null;
    }

    @Data
    public static class ProductEntity {
        private String id;
        private String title;
        private String description;
        private Double price;
        private String sku;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
