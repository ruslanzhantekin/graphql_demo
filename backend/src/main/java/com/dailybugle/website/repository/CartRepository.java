package com.dailybugle.website.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CartRepository {

    private static final CartEntity cart = new CartEntity("1");

    private static final CartItem cartItem1;
    private static final CartItem cartItem2;
    private static final CartItem cartItem3;

    static {
        cartItem1 = new CartItem("1", "1", "1",1, 100D);
        cartItem2 = new CartItem("2", "1", "2", 1,200D);
        cartItem3 = new CartItem("3", "1", "3", 1,300D);
    }

    public CartEntity get() {
        return cart;
    }

    public List<CartItem> findAllItems(String cartId) {
        if (cartId.equals(cart.id)) return List.of(cartItem1, cartItem2, cartItem3);

        return Collections.emptyList();
    }

    public CartItem findItemById(String cartItemId) {
        if (cartItemId.equals(cartItem1.id)) return cartItem1;
        if (cartItemId.equals(cartItem2.id)) return cartItem2;
        if (cartItemId.equals(cartItem3.id)) return cartItem3;

        return null;
    }

    public void addQnt(String cartItemId) {
        if (cartItemId.equals(cartItem1.id)) {
            cartItem1.qnt += 1;
            cartItem1.total += 100D;
        }

        if (cartItemId.equals(cartItem2.id)) {
            cartItem2.qnt += 1;
            cartItem2.total += 200D;
        }

        if (cartItemId.equals(cartItem3.id)) {
            cartItem3.qnt += 1;
            cartItem3.total += 300D;
        }
    }

    public void removeQnt(String cartItemId) {
        if (cartItemId.equals(cartItem1.id)) {
            cartItem1.qnt -= 1;
            cartItem1.total -= 100D;
        }

        if (cartItemId.equals(cartItem2.id)) {
            cartItem2.qnt -= 1;
            cartItem2.total -= 200D;
        }

        if (cartItemId.equals(cartItem3.id)) {
            cartItem3.qnt -= 1;
            cartItem3.total -= 300D;
        }
    }

    @Data
    @AllArgsConstructor
    public static class CartEntity {
        private String id;
    }

    @Data
    @AllArgsConstructor
    public static class CartItem {
        private String id;
        private String cartId;
        private String productId;
        private Integer qnt;
        private Double total;
    }
}
