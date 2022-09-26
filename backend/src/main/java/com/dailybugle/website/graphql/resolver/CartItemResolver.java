package com.dailybugle.website.graphql.resolver;

import com.dailybugle.website.graphql.ConverterUtils;
import com.dailybugle.website.graphql.type.CartItem;
import com.dailybugle.website.graphql.type.Product;
import com.dailybugle.website.repository.ProductRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CartItemResolver implements GraphQLResolver<CartItem> {

    private ProductRepository repository;

    public Product product(CartItem cart) {
        var product = repository.findById(cart.getProductId());
        return product != null ? ConverterUtils.toModel(product) : null;
    }
}
