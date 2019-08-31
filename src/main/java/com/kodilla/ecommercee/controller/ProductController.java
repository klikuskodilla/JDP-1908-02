package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.entity.GenericEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<GenericEntity> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public GenericEntity getProduct(@PathVariable("id") Long productId) {
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void addProduct(@RequestBody GenericEntity genericEntity) {}

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public GenericEntity updateProduct(@RequestBody GenericEntity genericEntity) {
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long productId) {}
}