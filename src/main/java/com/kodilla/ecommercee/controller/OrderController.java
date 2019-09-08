package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<OrderDto> getOrders(){
        return orderMapper.mapToOrderDtoList(orderService.getOrders());
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public OrderDto getOrder(@PathVariable Long id) throws NotFoundException {
        return orderMapper.mapToOrderDto(orderService.getOrder(id).orElseThrow(NotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}/delete")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public void createOrder(@RequestBody OrderDto orderDto){
        orderService.saveOrder(orderMapper.mapToOrder(orderDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "update")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
        return orderMapper.mapToOrderDto(orderService.saveOrder(orderMapper.mapToOrder(orderDto)));
    }

}
