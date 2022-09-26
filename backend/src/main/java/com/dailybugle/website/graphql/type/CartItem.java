package com.dailybugle.website.graphql.type;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private String id;
    private Cart cart;
    private String productId;
    private Double total;
    private Integer qnt;
}
