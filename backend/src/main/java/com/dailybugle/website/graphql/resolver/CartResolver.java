package com.dailybugle.website.graphql.resolver;

import com.dailybugle.website.graphql.ConverterUtils;
import com.dailybugle.website.graphql.type.Cart;
import com.dailybugle.website.graphql.type.CartItem;
import com.dailybugle.website.repository.CartRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class CartResolver implements GraphQLResolver<Cart> {

    private final CartRepository cartRepository;

    public List<CartItem> items(Cart cart) {
        return cartRepository.findAllItems(cart.getId())
                .stream()
                .map(item -> ConverterUtils.toModel(item, cart))
                .collect(toList());
    }

    public Double subtotal(Cart cart) {
        return items(cart).stream().mapToDouble(CartItem::getTotal).sum();
    }
}
