package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTest {

    @Autowired
    private OrderRepository repository;

    @Test
    public void testOrderEntitySave() {
        //given
        OrderEntity order = new OrderEntity();
        order.setDateOfOrder(LocalDate.now());

        //when
        repository.save(order);

        //then
        Long id = order.getOrderId();
        Optional<OrderEntity> receivedOrder = repository.findById(id);
        Assert.assertTrue(receivedOrder.isPresent());

        //cleanUp
        repository.deleteById(id);
    }

    @Test
    public void testOrderEntitySaveWithCart() {
        //given
        OrderEntity order = new OrderEntity();
        order.setDateOfOrder(LocalDate.now());
        order.setCartEntity(new CartEntity());

        //when
        repository.save(order);

        //then
        Long id = order.getOrderId();
        Optional<OrderEntity> receivedOrder = repository.findById(id);
        Assert.assertTrue(receivedOrder.isPresent());

        //cleanUp
        repository.deleteById(id);
    }

}
