package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<GenericEntity> getOrders(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public GenericEntity getOrder(Long id){
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(Long id){

    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(GenericEntity genericEntity){

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public GenericEntity updateOrder(Long id){
        return new GenericEntity();
    }

}
