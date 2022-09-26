package com.dailybugle.website.graphql.query;

import com.dailybugle.website.graphql.ConverterUtils;
import com.dailybugle.website.graphql.type.Cart;
import com.dailybugle.website.graphql.type.Product;
import com.dailybugle.website.repository.CartRepository;
import com.dailybugle.website.repository.ProductRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public List<Product> products() {
        return productRepository.findAll()
                .stream()
                .map(ConverterUtils::toModel)
                .collect(toList());
    }

    public Product product(String id) {
        var product = productRepository.findById(id);
        return product != null ? ConverterUtils.toModel(product) : null;
    }

    public Cart cart() {
        var cart = cartRepository.get();
        return cart != null ? ConverterUtils.toModel(cart) : null;
    }
}
