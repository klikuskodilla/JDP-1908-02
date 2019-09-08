package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CartEntityTest {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    //@Autowired
    //ProductRepository productRepository;


    @Test
    public void cartSaveTest(){
        //given
        UserEntity user = new UserEntity("UKey:test", "Status:active", "login:test", "pass:test", "fname:test", "lname:test", "street:test", "city:test", "postCode", "phone", "test@test.com");
        ProductEntity pen = new ProductEntity();
        Map<ProductEntity, Integer> products = new HashMap<>();
        //   products.put(pen, 4);
        CartEntity newCart = new CartEntity(user, products);

        //when
        userRepository.save(user);
        cartRepository.save(newCart);
// productRepository.save(pen);

        int id = newCart.getCartId();
        Optional<CartEntity> cart = cartRepository.findById(id);

        int userId = user.getId();


        //then
        Assert.assertTrue(cart.isPresent());
        Assert.assertEquals(userId, cart.get().getUserEntity().getId());
        //Assert.assertEquals(4, cart.get().getProductMap().get(pen));

        // cleanUp
        cartRepository.deleteById(id);
        userRepository.deleteById(userId);
    }

    @Test
    public void cardDeletingUserNotDeletingTest(){
        //given
        UserEntity user = new UserEntity("UKey:test", "Status:active", "login:test", "pass:test", "fname:test", "lname:test", "street:test", "city:test", "postCode", "phone", "test@test.com");
        Map<ProductEntity, Integer> products = new HashMap<>();
        CartEntity newCart = new CartEntity(user, products);

        //when
        userRepository.save(user);
        cartRepository.save(newCart);

        //then
        int id = newCart.getCartId();
        int userId = user.getId();
        cartRepository.deleteById(id);
        Optional<UserEntity> newUser = userRepository.findById(userId);
        Optional<CartEntity> cart = cartRepository.findById(id);
        Assert.assertFalse(cart.isPresent());
        Assert.assertTrue(newUser.isPresent());

        // cleanUp
        userRepository.deleteById(userId);
    }

    @Test
    public void cardDeletingProductsNotDeletingTest(){
        //given
        UserEntity user = new UserEntity("UKey:test", "Status:active", "login:test", "pass:test", "fname:test", "lname:test", "street:test", "city:test", "postCode", "phone", "test@test.com");
        ProductEntity pen = new ProductEntity("pen", new BigDecimal(1.5), "description");
        Map<ProductEntity, Integer> products = new HashMap<>();
        //   products.put(pen, 4);
        CartEntity newCart = new CartEntity(user, products);

        //when
        userRepository.save(user);
        cartRepository.save(newCart);
        //productRepository.save(pen);

        //then
        int id = newCart.getCartId();
        //int penId = pen.getId();
        //Optional<ProductEntity> newPen = productRepository.findById(penId);
        cartRepository.deleteById(id);
        Optional<CartEntity> cart = cartRepository.findById(id);

        Assert.assertFalse(cart.isPresent());
        //Assert.assertTrue(newPen.isPresent());

        // cleanUp
        int userId = user.getId();
        userRepository.deleteById(userId);
        //productRepository.deleteById(penId);
    }

    @Test
    public void addingProductToCartTest(){
        //given
        UserEntity user = new UserEntity("key", "status", "login", "pass", "name", "lastname", "street", "city", "postcode", "phone", "mail");
        ProductEntity pen = new ProductEntity("pen", new BigDecimal(1.5), "description");
        Map<ProductEntity, Integer> products = new HashMap<>();
        CartEntity newCart = new CartEntity(user, products);

        //when
        cartRepository.save(newCart);
        userRepository.save(user);
        //productRepository.save(pen);

        int cartId = newCart.getCartId();
        Optional<CartEntity> cart = cartRepository.findById(cartId);
        cart.get().getProductMap().put(pen, 3);

        //then
        //Assert.assertEquals(1, cart.get().getProductMap.size())

        //cleanUp
        int userId = user.getId();
        userRepository.deleteById(userId);
        cartRepository.deleteById(cartId);
        //int penId = pen.getId();
        //productRepository.deleteById(penId);
    }
}