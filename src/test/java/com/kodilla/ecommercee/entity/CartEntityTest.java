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
        UserEntity user = new UserEntity("key", "status", "login", "pass", "name", "lastname", "street", "city", "postcode", "phone", "mail");
        ProductEntity pen = new ProductEntity("pen", new BigDecimal(1.5), "description");
        ProductEntity pencil = new ProductEntity("pencil", new BigDecimal(1.2), " ");
        ProductEntity notebook = new ProductEntity("notebook", new BigDecimal(2.5), " ");
        Map<ProductEntity, Integer> products = new HashMap<>();
        //   products.put(pen, 4);
        //   products.put(pencil, 1);
        //   products.put(notebook, 2);
        CartEntity newCart = new CartEntity(user, products);

        //when
        userRepository.save(user);
        cartRepository.save(newCart);

        //then
        int id = newCart.getCartId();
        Optional<CartEntity> cart = cartRepository.findById(id);
        Assert.assertTrue(cart.isPresent());

        // cleanUp
        int userId = user.getId();
        cartRepository.deleteById(id);
        userRepository.deleteById(userId);
    }

    @Test
    public void cardDeletingUserNotDeletingTest(){
        //given
        UserEntity user = new UserEntity("key", "status", "login", "pass", "name", "lastname", "street", "city", "postcode", "phone", "mail");
        ProductEntity pen = new ProductEntity("pen", new BigDecimal(1.5), "description");
        ProductEntity pencil = new ProductEntity("pencil", new BigDecimal(1.2), " ");
        ProductEntity notebook = new ProductEntity("notebook", new BigDecimal(2.5), " ");
        Map<ProductEntity, Integer> products = new HashMap<>();
        //   products.put(pen, 4);
        //   products.put(pencil, 1);
        //   products.put(notebook, 2);
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
        UserEntity user = new UserEntity("key", "status", "login", "pass", "name", "lastname", "street", "city", "postcode", "phone", "mail");
        ProductEntity pen = new ProductEntity("pen", new BigDecimal(1.5), "description");
        ProductEntity pencil = new ProductEntity("pencil", new BigDecimal(1.2), " ");
        ProductEntity notebook = new ProductEntity("notebook", new BigDecimal(2.5), " ");
        Map<ProductEntity, Integer> products = new HashMap<>();
        //   products.put(pen, 4);
        //   products.put(pencil, 1);
        //   products.put(notebook, 2);
        CartEntity newCart = new CartEntity(user, products);

        //when
        userRepository.save(user);
        cartRepository.save(newCart);

        //then
        int id = newCart.getCartId();
        //int penId = pen.getId();
        //int pencilId = pencil.getId();
        //int notebookId = notebook.getId();
        //Optional<ProductEntity> newPen = productRepository.findById(penId);
        //Optional<ProductEntity> newPencil = productRepository.findById(pencilId);
        //Optional<ProductEntity> newNotebook = productRepository.findById(notebookId);
        cartRepository.deleteById(id);
        Optional<CartEntity> cart = cartRepository.findById(id);

        Assert.assertFalse(cart.isPresent());
        //Assert.assertTrue(newPen.isPresent());
        //Assert.assertTrue(newPencil.isPresent());
        //Assert.assertTrue(newNotebook.isPresent());


        // cleanUp
        int userId = user.getId();
        userRepository.deleteById(userId);
        //productRepository.deleteById(penId);
        //productRepository.deleteById(pencilId);
        //productRepository.deleteById(notebookId);
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

        Map<ProductEntity, Integer> newMap = new HashMap<>();
        newMap.put(pen, 5);

       // newCart.setProductMap(newMap);
        int cartId = newCart.getCartId();

        //then
        //Assert.assertEquals(1, cartRepository.findById(cartId).getProductMap.size())

        //cleanUp
        int userId = user.getId();
        userRepository.deleteById(userId);
        cartRepository.deleteById(cartId);

    }
}