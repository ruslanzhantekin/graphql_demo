package com.dailybugle.website.graphql.resolver;

import com.dailybugle.website.graphql.type.Product;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductResolver implements GraphQLResolver<Product> {

    public String image(Product product) {
        return "https://picsum.photos/150/150";
    }

    public List<String> images(Product product) {
        return List.of(
                "https://picsum.photos/150/150",
                "https://picsum.photos/200/300",
                "https://picsum.photos/200/200"
        );
    }
}
