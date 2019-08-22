package com.kodilla.ecommercee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "1/carts", produces = "application/json")
public class CartController {

    @Autowired
    private GenericEntityRepository cartRepository;

    @PostMapping()
    public void createCart() {
        cartRepository.save(new GenericEntity());
    }

    @GetMapping("{cartId}")
    public List<GenericEntity> getProducts(@PathVariable Long cartId) throws Exception {
        GenericEntity cart = cartRepository.findById(cartId).orElseThrow(Exception::new);
        return cart.getGenericEntityList();
    }

    @PostMapping("{cartId}/products")
    public GenericEntity addProducts(@PathVariable Long cartId,
                                     @RequestBody List<GenericEntity> productList) throws Exception {
        GenericEntity cart = cartRepository.findById(cartId).orElseThrow(Exception::new);
        for (GenericEntity product : productList) {
            cart.getGenericEntityList().add(product);
        }
        return cart;
    }

    @DeleteMapping("{cartId}/products/{productId}")
    public boolean removeProduct(@PathVariable Long cartId,
                                 @PathVariable Long productId) throws Exception {
        GenericEntity cart = cartRepository.findById(cartId).orElseThrow(Exception::new);
        GenericEntity product = cartRepository.findById(productId).orElseThrow(Exception::new);
        return cart.getGenericEntityList().remove(product);
    }

    @PostMapping("{cardId}/createOrder")
    public GenericEntity createOrder(@PathVariable Long cartId) throws Exception {
        GenericEntity cart = cartRepository.findById(cartId).orElseThrow(Exception::new);
        GenericEntity order = new GenericEntity("cart");
        return order;
    }
}
