package com.dailybugle.website.graphql.mutation;

import com.dailybugle.website.graphql.ConverterUtils;
import com.dailybugle.website.graphql.type.CartItem;
import com.dailybugle.website.repository.CartRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {

    private final CartRepository cartRepository;

    public CartItem addQnt(String cartItemId) {
        var item = cartRepository.findItemById(cartItemId);

        if (item == null)
            return null;

        var cart = cartRepository.get();
        cartRepository.addQnt(item.getId());

        return ConverterUtils.toModel(item, ConverterUtils.toModel(cart));
    }

    public CartItem removeQnt(String cartItemId) {
        var item = cartRepository.findItemById(cartItemId);

        if (item == null)
            return null;

        var cart = cartRepository.get();
        cartRepository.removeQnt(item.getId());

        return ConverterUtils.toModel(item, ConverterUtils.toModel(cart));
    }
}
