package com.dailybugle.website.graphql.type;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Cart {
    private String id;
//    private List<CartItem> items;
//    private Double subtotal;
}
