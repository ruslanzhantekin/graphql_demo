package com.dailybugle.website.graphql;

import com.dailybugle.website.graphql.type.Cart;
import com.dailybugle.website.graphql.type.CartItem;
import com.dailybugle.website.graphql.type.Product;
import com.dailybugle.website.repository.CartRepository;
import com.dailybugle.website.repository.ProductRepository.ProductEntity;

public class ConverterUtils {

    public static Product toModel(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .title(productEntity.getTitle())
                .description(productEntity.getDescription())
                .sku(productEntity.getSku())
                .price(productEntity.getPrice())
                .build();
    }

    public static Cart toModel(CartRepository.CartEntity cart) {
        return Cart.builder()
                .id(cart.getId())
                .build();
    }

    public static CartItem toModel(CartRepository.CartItem cartItem, Cart cart) {
        return CartItem.builder()
                .id(cartItem.getId())
                .qnt(cartItem.getQnt())
                .total(cartItem.getTotal())
                .cart(cart)
                .productId(cartItem.getProductId())
                .build();
    }
}
