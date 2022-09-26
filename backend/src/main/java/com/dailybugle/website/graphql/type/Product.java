package com.dailybugle.website.graphql.type;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String id;
    private String title;
    private String description;
    private Double price;
    private String sku;
}
