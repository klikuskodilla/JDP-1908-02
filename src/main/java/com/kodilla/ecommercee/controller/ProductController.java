package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.entity.GenericEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<GenericEntity> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public GenericEntity getProduct(Long productId) {
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct")
    public void addProduct(GenericEntity genericEntity) {}

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public GenericEntity updateProduct(GenericEntity genericEntity) {
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(Long productId) {}
}
